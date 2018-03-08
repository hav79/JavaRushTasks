package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(filename2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Pattern p = Pattern.compile("\\b(\\d+)\\b");
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            Matcher matcher = p.matcher(s);
            while (matcher.find()) {
                String num = matcher.group(1);
                bufferedWriter.write( num + " ");
            }
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();
    }
}
