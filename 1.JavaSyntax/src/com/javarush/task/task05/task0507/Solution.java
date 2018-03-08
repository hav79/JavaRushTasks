package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int n = 0;// scanner.nextInt();
        double sum = 0;
        int count = 0;
        while (true) {
            n = scanner.nextInt();
            if (n == -1)
                break;
            sum += n;
            count++;
        }
        System.out.println(sum / count);
    }
}

