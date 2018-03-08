package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] pow10 = new int[10];
        for (int i = 0; i < 20; i++) pow10[i] = (int) Math.pow(10, i);
        byte[] number = new  byte[10];
        ArrayList<Integer> result = new ArrayList<>();
        byte lastCount = 1;

    mark:    for (int i = 0; i < N; i++) {
            byte count = (byte) Long.toString(i).length();
            int x = i;
            int prevDigit = 0;
            for (int j = count-1; j >= 0; j--) {
                int digit = x / pow10[j];
                if (digit < prevDigit)
                    continue mark;
                prevDigit = digit;
                x = x % pow10[j];
            }
            int sum = 0;
            if (count > lastCount) {
                for (int j = 0; j < digits.length; j++) digits[j] = digits[j] * j;
                lastCount++;
            }
            int tmp = i;
            for (byte j = 0; j < 10; j++) {
                number[j] = (byte) (tmp % 10);
                tmp /= 10;
            }
            for (int j = 0; j < 10; j++) sum += digits[number[j]];
            if (sum == i) result.add(i);
        }

        long[] res = new long[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
