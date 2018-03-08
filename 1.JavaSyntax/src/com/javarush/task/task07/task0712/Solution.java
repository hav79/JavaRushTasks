package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int max = 0;
        int min = 1000;
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            strings.add(s);
            if (s.length() > max)
                max = s.length();
            if (s.length() < min)
                min = s.length();
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == max) {
                System.out.println(strings.get(i));
                break;
            }
            else if (strings.get(i).length() == min) {
                System.out.println(strings.get(i));
                break;
            }
        }
    }
}
