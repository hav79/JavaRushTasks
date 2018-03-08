package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> lines = new ArrayList<>();

        while (reader.ready()) {
            String s = reader.readLine();
            lines.add(s);
        }

        inputStream.close();
        reader.close();

        if (args[0].equals("-u")) {
            String id = args[1];
            String productName = args[2];
            String price = args[3];
            String quantity = args[4];
            ArrayList<String> linesCopy = new ArrayList<>(lines);
            for (int i = 0; i < linesCopy.size(); i++) {
                String line = linesCopy.get(i);
                if (line.startsWith(id))
                    lines.set(i, String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity));
            }
        } else if (args[0].equals("-d")) {
            ArrayList<String> linesCopy = new ArrayList<>(lines);
            for (int i = 0; i < linesCopy.size(); i++) {
                String line = linesCopy.get(i);
                if (line.startsWith(args[1]))
                    lines.remove(i);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
    }
}
