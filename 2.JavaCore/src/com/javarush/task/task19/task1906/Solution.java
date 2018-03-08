package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = console.readLine();
        String filename2 = console.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(filename1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));

        boolean isEven = false;
        while (reader.ready()) {
            int c = reader.read();
            if (isEven)
                writer.write(c);
            isEven = !isEven;
        }

        reader.close();
        writer.close();
    }
}
