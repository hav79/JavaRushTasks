package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename1 = scanner.nextLine();
        String filename2 = scanner.nextLine();

        FileInputStream inputStream1 = new FileInputStream(filename1);
        FileInputStream inputStream2 = new FileInputStream(filename2);
        FileOutputStream outputStream = new FileOutputStream(filename1);

        int[] buffer = new int[inputStream1.available()];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = inputStream1.read();
        }

        while (inputStream2.available() > 0)
            outputStream.write(inputStream2.read());

        for (int i = 0; i < buffer.length; i++) {
            outputStream.write(buffer[i]);
        }

        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
