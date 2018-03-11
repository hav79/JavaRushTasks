package com.javarush.task.task22.task2203;

import java.util.stream.IntStream;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        int count = (int) IntStream.range(0, string.length()).filter(i -> string.charAt(i) == '\t').count();
        if (count < 2) throw new TooShortStringException();

        String[] parts = string.split("\t");
        try {
            return parts[1];
        } catch (RuntimeException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
