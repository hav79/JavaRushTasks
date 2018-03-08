package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> result = new ArrayList<>();
        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            for (String aLine : line)
                if (aLine.length() > 6)
                    result.add(aLine);
        }
        writer.write(String.join(",", result));

        reader.close();
        writer.close();
    }
}
