package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String[] p = Arrays.stream(args).skip(1).sorted().toArray(String[]::new);
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(p));

        ArrayList<InputStream> partStreams = new ArrayList<>();
        for (String part : parts) partStreams.add(new FileInputStream(part));

        try (ZipInputStream zipInputStream = new ZipInputStream(
                new SequenceInputStream(Collections.enumeration(partStreams)));
             FileOutputStream outputStream = new FileOutputStream(args[0], true)) {

            ZipEntry entry = zipInputStream.getNextEntry();
            int count = 0;
            byte[] buffer = new byte[1024];
            while ((count = zipInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }
            zipInputStream.closeEntry();
        }
    }
}
