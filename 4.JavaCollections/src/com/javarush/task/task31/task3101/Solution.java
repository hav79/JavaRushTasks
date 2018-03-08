package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try (FileOutputStream outputStream = new FileOutputStream(allFilesContent)) {

            Queue<String> dirs = new PriorityQueue<>();
            dirs.add(folder.getAbsolutePath());
            ArrayList<File> files = new ArrayList<>();
            while (!dirs.isEmpty()) {
                File dir = new File(dirs.poll());
                File[] children = dir.listFiles();
                for (File file : children) {
                    if (file.isDirectory())
                        dirs.add(file.getAbsolutePath());
                    else if (file.isFile() && file.length() <= 50) {
                        files.add(file);
                    }
                }
            }
            files.sort(Comparator.comparing(File::getName));

            for (File file : files) {
                FileInputStream inputStream = new FileInputStream(file);
                while (inputStream.available() > 0)
                    outputStream.write(inputStream.read());
                outputStream.write('\n');
                inputStream.close();
            }
        }
    }
}
