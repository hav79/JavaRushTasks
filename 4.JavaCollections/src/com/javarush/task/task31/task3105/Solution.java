package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, ByteArrayOutputStream> content;

        String zipFileName = args[1];
        try (ZipInputStream zipInputStream = new ZipInputStream(
                new FileInputStream(zipFileName))) {

            content = new HashMap<>();
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipInputStream.read(buffer)) != -1)
                    arrayOutputStream.write(buffer, 0, count);
                content.put(entry.getName(), arrayOutputStream);
            }
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(
                new FileOutputStream(zipFileName))) {

            Path filename = Paths.get(args[0]);
            for (Map.Entry<String, ByteArrayOutputStream> streamEntry : content.entrySet()) {
                if (streamEntry.getKey().endsWith(filename.getName(filename.getNameCount() - 1).toString()))
                    continue;
                ZipEntry outEntry = new ZipEntry(streamEntry.getKey());
                zipOutputStream.putNextEntry(outEntry);
                streamEntry.getValue().writeTo(zipOutputStream);
                zipOutputStream.closeEntry();
            }
            zipOutputStream.putNextEntry(new ZipEntry(
                            "new" + File.separator
                                    + filename.getName(filename.getNameCount() - 1)));
            Files.copy(filename, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }
}
