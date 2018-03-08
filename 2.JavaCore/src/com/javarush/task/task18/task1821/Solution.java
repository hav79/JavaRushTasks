package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        while (inputStream.available() > 0) {
            char ch = (char) inputStream.read();
            symbols.put(ch, symbols.getOrDefault(ch, 0) + 1);
        }

        inputStream.close();

        symbols.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
