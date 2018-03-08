package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> newList = new ArrayList<>();
        for (String s : list) {
            if (s.length() % 2 == 0)
                newList.add(s + " " + s);
            else
                newList.add(s + " " + s + " " + s);
        }

        for (String s : newList) {
            System.out.println(s);
        }
    }
}
