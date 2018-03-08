package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(filename);

        TreeSet<Integer> bytes = new TreeSet<>();
        while (inputStream.available() > 0) {
            int b = inputStream.read();
            bytes.add(b);
        }

        for (Integer aByte : bytes) {
            System.out.print(aByte + " ");
        }

        inputStream.close();
    }
}
