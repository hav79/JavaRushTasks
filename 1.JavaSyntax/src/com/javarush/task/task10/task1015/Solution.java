package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Random;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        Random random = new Random();
        ArrayList<String>[] arrayLists = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            arrayLists[i] = new ArrayList<>();
            for (int j = 0; j < 10; j++) arrayLists[i].add("string " + random.nextInt(100));
        }
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}