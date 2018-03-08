package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootFolder = new File(root);
        Queue<String> dirs = new PriorityQueue<>();
        dirs.add(rootFolder.getAbsolutePath());
        ArrayList<String> files = new ArrayList<>();
        while (!dirs.isEmpty()) {
            File dir = new File(dirs.poll());
            File[] children = dir.listFiles();
            for (File file : children) {
                if (file.isDirectory())
                    dirs.add(file.getAbsolutePath());
                else if (file.isFile()) {
                    files.add(file.getAbsolutePath());
                }
            }
        }
        return files;

    }

    public static void main(String[] args) {
        
    }
}
