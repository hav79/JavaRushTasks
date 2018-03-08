package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().replaceAll("\\s", "");
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> other = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i)))
                vowels.add(str.charAt(i));
            else
                other.add(str.charAt(i));
        }
        for (Character vowel : vowels) {
            System.out.print(vowel + " ");
        };
        System.out.println();
        for (Character ch : other) {
            System.out.print(ch + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}