package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(filename);

        int count = 0;
        while (inputStream.available() > 0) {
            int b = inputStream.read();
            if (b == (int)',') count++;
        }

        System.out.println(count);
        inputStream.close();
    }
}
