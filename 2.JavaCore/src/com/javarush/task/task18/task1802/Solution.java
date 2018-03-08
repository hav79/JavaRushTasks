package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(filename);

        int min = Integer.MAX_VALUE;
        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (b < min) min = b;
        }
        System.out.println(min);
        inputStream.close();
    }
}
