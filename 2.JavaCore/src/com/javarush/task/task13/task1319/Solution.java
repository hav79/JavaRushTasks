package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        while (true) {
            line = reader.readLine();
            if (line.equals("exit")) {
                lines.add(line);
                break;
            }
            lines.add(line);
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
        for (String s : lines) {
            fileWriter.write(s);
            fileWriter.newLine();
        }
        fileWriter.close();
        reader.close();
    }
}
