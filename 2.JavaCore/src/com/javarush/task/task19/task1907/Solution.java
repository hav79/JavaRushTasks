package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Pattern p = Pattern.compile("\\bworld\\b");
        int count = 0;
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            Matcher matcher = p.matcher(s);
            while (matcher.find())
                count++;
        }
        fileReader.close();
        bufferedReader.close();
        System.out.println(count);
    }
}
