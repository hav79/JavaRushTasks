package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n-1; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num > maximum)
                maximum = num;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
