package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        InputStream fileStream = new FileInputStream(filename);
        while (fileStream.available() > 0) {
            int data = fileStream.read();
            System.out.print((char) data);
        }
        System.out.println();
        reader.close();
        fileStream.close();
    }
}