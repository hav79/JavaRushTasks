package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path folder = Paths.get(reader.readLine());
        if (!Files.isDirectory(folder)) {
            System.out.println(folder.toAbsolutePath().toString() + " - не папка");
            return;
        }
        CountVisitor visitor = new CountVisitor();
        Files.walkFileTree(folder, visitor);
        System.out.println("Всего папок - " + visitor.getDirCount());
        System.out.println("Всего файлов - " + visitor.getFileCount());
        System.out.println("Общий размер - " + visitor.getTotalSize());

    }

    public static class CountVisitor extends SimpleFileVisitor<Path> {
        private int dirCount;
        private int fileCount;
        private long totalSize;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isRegularFile(file)) {
                fileCount++;
                totalSize += attrs.size();
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (Files.isDirectory(dir))
                dirCount++;
            return super.preVisitDirectory(dir, attrs);
        }

        public int getDirCount() {
            return dirCount - 1;
        }

        public int getFileCount() {
            return fileCount;
        }

        public long getTotalSize() {
            return totalSize;
        }
    }
}
