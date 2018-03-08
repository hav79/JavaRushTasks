package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        int maxId = Integer.MIN_VALUE;
        while (reader.ready()) {
            String sId = reader.readLine().substring(0, 8).trim();
            int id = Integer.parseInt(sId);
            if (id > maxId) maxId = id;
        }
        inputStream.close();
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.newLine();
        writer.write(String.format("%-8d%-30s%-8s%-4s%n", maxId+1, productName, price, quantity));
        writer.close();
    }
}
