package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num > 0)
            System.out.println(2 * num);
        else if (num < 0)
            System.out.println(num + 1);
        else
            System.out.println(num);

    }

}