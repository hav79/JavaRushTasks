package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

        double max = Double.MIN_VALUE;
        for (Double aDouble : salaries.values()) {
            if (aDouble > max) max = aDouble;
        }
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == max) names.add(entry.getKey());
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
