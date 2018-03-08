package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character character : alphabet) {
            count.put(character, 0);
        }
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                count.put(c, count.get(c) + 1);
            }
        }

        for (Character ch :alphabet){
            System.out.println(ch + " " + count.get(ch));
        }
    }

}
