package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int num1 = scanner.nextInt();
        if (num1 > 0) count++;
        int num2 = scanner.nextInt();
        if (num2 > 0) count++;
        int num3 = scanner.nextInt();
        if (num3 > 0) count++;
        System.out.println(count);
    }
}
