package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
            if (s.length() > max)
                max = s.length();
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == max)
                System.out.println(strings.get(i));
        }
    }
}
