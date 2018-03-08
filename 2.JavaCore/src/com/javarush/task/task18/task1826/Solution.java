package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    private static final int key = 42;

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (args[0].equals("-e"))
                outputStream.write(data + key);
            else if (args[0].equals("-d"))
                outputStream.write(data - key);
        }
        inputStream.close();
        outputStream.close();
    }
}
