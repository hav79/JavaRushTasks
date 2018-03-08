package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int count = 0;

        while (inputStream.available() > 0) {
            int ch = inputStream.read();
            String letter = String.valueOf((char) ch);
            if (alphabet.contains(letter.toLowerCase()))
                count++;
        }
        System.out.println(count);
        inputStream.close();
    }
}
