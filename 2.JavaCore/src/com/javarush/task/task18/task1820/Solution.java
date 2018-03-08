package com.javarush.task.task18.task1820;

/* 
Округление чисел
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

        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);

        StringBuilder str = new StringBuilder();

        while (inputStream.available() > 0) {
            str.append((char) inputStream.read());
        }
        String[] buffer = str.toString().split(" ");

        for (int i = 0; i < buffer.length; i++) {
            double d = Double.parseDouble(buffer[i]);
            String s = String.valueOf(Math.round(d));
            for (int j = 0; j < s.length(); j++) {
                outputStream.write((int)s.charAt(j));
            }
            outputStream.write((int) ' ');
        }
        inputStream.close();
        outputStream.close();
    }
}
