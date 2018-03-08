package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(filename);

        HashMap<Integer, Integer> counts = new HashMap<>();

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            int count = counts.getOrDefault(b, 0);
            counts.put(b, count + 1);
        }

        int minCount = Integer.MAX_VALUE;
        for (Integer value : counts.values()) {
            if (value < minCount) minCount = value;
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == minCount)
                System.out.print(entry.getKey() + " ");
        }

        inputStream.close();
    }
}
