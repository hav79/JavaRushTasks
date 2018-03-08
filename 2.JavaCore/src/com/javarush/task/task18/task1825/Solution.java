package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> files = new ArrayList<>();

        while (true) {
            String filename = scanner.nextLine();
            if (filename.equals("end")) break;
            files.add(filename);
        }
        Collections.sort(files);

        String s1 = files.get(0);
        String out = s1.substring(0, s1.lastIndexOf(".part"));
        byte[] buffer = new byte[1000];

        FileOutputStream outputStream = new FileOutputStream(out);
        for (String file : files) {
            FileInputStream inputStream = new FileInputStream(file);
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }

        outputStream.close();
    }
}
