package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        if (s1.equals(s2))
            System.out.println("Имена идентичны");
        else if (s1.length() == s2.length())
            System.out.println("Длины имен равны");
    }
}
