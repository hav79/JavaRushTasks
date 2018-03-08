package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean even = num % 2 == 0;
        if (num > 0 && num < 1000) {
            if (even)
                System.out.print("четное ");
            else
                System.out.print("нечетное ");
            if (num < 10)
                System.out.print("однозначное ");
            else if (num < 100)
                System.out.print("двузначное ");
            else
                System.out.print("трехзначное ");
            System.out.println("число");
        }

    }
}
