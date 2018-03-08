package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean sign = num > 0;
        boolean even = num % 2 == 0;
        if (num == 0)
            System.out.println("ноль");
        else {
            if (sign)
                System.out.print("положительное ");
            else
                System.out.print("отрицательное ");
            if (even)
                System.out.print("четное ");
            else
                System.out.print("нечетное ");
            System.out.println("число");
        }
    }
}
