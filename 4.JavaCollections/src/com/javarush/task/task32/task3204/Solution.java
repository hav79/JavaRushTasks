package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String[] symbols = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "abcdefghijklmnopqrstuvwxyz",
                "0123456789"};
        boolean hasNumbers = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(3);
            char c = symbols[number].charAt(random.nextInt(symbols[number].length()));
            hasNumbers = Character.isDigit(c) || hasNumbers;
            hasLowerCase = Character.isLowerCase(c) || hasLowerCase;
            hasUpperCase = Character.isUpperCase(c) || hasUpperCase;
            outputStream.write(c);
        }
        if (hasLowerCase && hasUpperCase && hasNumbers)
            return outputStream;
        else return getPassword();
    }
}