package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> salaries = new TreeMap<>();
        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.split(" ")[0];
            double salary = Double.parseDouble(line.split(" ")[1]);
            salaries.put(name, salaries.getOrDefault(name, 0.0) + salary);
        }
        reader.close();

        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
