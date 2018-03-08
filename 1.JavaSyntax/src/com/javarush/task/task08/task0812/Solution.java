package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));
        int max = 0;
        int cur = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i-1)))
                cur++;
            else {
                max = cur > max ? cur : max;
                cur = 1;
            }
            if (cur > max)
                max = cur;
        }
        System.out.println(max);
    }
}