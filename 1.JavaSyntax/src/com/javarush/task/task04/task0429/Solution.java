package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int pos_count = 0;
        int neg_count = 0;
        int num1 = scanner.nextInt();
        if (num1 > 0) pos_count++; else if (num1 < 0) neg_count++;
        int num2 = scanner.nextInt();
        if (num2 > 0) pos_count++; else if (num2 < 0)  neg_count++;
        int num3 = scanner.nextInt();
        if (num3 > 0) pos_count++; else if (num3 < 0)  neg_count++;
        System.out.println("количество отрицательных чисел: " + neg_count);
        System.out.println("количество положительных чисел: " + pos_count);
    }
}
