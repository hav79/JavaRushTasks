package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] ar1 = {1, 2, 3, 4, 5};
        int[] ar2 = {6, 7};
        int[] ar3 = {8, 9, 0, 11};
        int[] ar4 = {12, 13, 14, 15, 16, 17, 18};
        int[] ar5 = {};
        list.add(ar1);
        list.add(ar2);
        list.add(ar3);
        list.add(ar4);
        list.add(ar5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
