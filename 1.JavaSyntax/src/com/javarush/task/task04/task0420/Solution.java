package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 2; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }

        for (int i = 0; i < 3; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
