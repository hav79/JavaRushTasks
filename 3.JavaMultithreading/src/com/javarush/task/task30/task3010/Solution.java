package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int maxNum = 0;
        try {
            String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            maxNum = 0;
            for (int i = 0; i < args[0].length(); i++) {
                char c = args[0].toUpperCase().charAt(i);
                int index = symbols.indexOf(c) + 1;
                if (index == 0) {
                    System.out.println("incorrect");
                    return;
                }
                if (index > maxNum)
                    maxNum = index;
            }
        } catch (Exception e) {

        }
        if (maxNum < 2) maxNum = 2;
        System.out.println(maxNum);
    }
}