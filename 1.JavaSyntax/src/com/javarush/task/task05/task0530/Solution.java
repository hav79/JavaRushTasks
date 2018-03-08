package com.javarush.task.task05.task0530;

import java.io.*;
import java.util.Scanner;

/* 
Шеф, что-то не пашет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
