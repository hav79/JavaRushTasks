package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int n = 0;// scanner.nextInt();
        int sum = 0;
        while (n != -1) {
            n = scanner.nextInt();
            sum += n;
        }
        System.out.println(sum);
    }
}
