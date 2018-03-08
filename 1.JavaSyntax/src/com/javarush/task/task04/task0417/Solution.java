package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        if (num1 == num2) {
            System.out.print(num1);
            System.out.print(" " + num2);
            if (num1 == num3)
                System.out.println(" " + num3);
        } else if (num2 == num3) {
            System.out.print(num2);
            System.out.print(" " + num3);
            if (num2 == num1)
                System.out.println(" " + num1);
        } else if (num1 == num3) {
            System.out.print(num1);
            System.out.print(" " + num3);
            if (num1 == num2)
                System.out.println(" " + num2);
        }
    }
}