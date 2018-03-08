package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(filename);

        int max = Integer.MIN_VALUE;
        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (b > max) max = b;
        }
        System.out.println(max);
        inputStream.close();
    }
}
