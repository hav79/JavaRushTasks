package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        while (reader.ready()) {
            String s = reader.readLine();
            String[] line = s.split(" ");
            for (int i = 0; i < line.length; i++) {
                matcher = pattern.matcher(line[i]);
                if (matcher.find())
                    writer.write(line[i] + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
