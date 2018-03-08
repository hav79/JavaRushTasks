package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        try {
            System.out.println(days[n - 1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("такого дня недели не существует");
        }
    }
}