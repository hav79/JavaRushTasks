package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> letters = new TreeSet<>();
        FileReader reader = new FileReader(args[0]);
        int b;
        while ((b = reader.read()) != -1) {
            char ch = (char) b;
            if (Character.isLetter(ch))
                letters.add(ch);
        }
        for (int i = 0; i < 5; i++) {
            Character c = letters.pollFirst();
            if (c != null)
                System.out.print(c);
        }
    }
}
