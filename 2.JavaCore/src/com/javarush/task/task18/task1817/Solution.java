package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        int count = 0;
        int spaceCount = 0;

        while (inputStream.available() > 0) {
            int ch = inputStream.read();
            count++;
            if ((char) ch == ' ')
                spaceCount++;
        }
        double result = 100 * (1.0 * spaceCount) / count;

        System.out.format("%.2f", result);
        inputStream.close();
    }
}
