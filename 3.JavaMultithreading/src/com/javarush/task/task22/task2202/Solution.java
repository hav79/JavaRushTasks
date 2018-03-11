package com.javarush.task.task22.task2202;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();

        int count = (int) IntStream.range(0, string.length()).filter(i -> string.charAt(i) == ' ').count();
        if (count < 4) throw new TooShortStringException();

        String[] parts = string.split(" ");
        try {
            return String.format("%s %s %s %s", parts[1], parts[2], parts[3], parts[4]);
        } catch (RuntimeException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
