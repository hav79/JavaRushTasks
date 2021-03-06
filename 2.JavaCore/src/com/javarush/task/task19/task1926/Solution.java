package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        while (fileReader.ready()) {
            StringBuilder result = new StringBuilder(fileReader.readLine());
            System.out.println(result.reverse().toString());
        }
        reader.close();
        fileReader.close();
    }
}
