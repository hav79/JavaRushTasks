package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
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

        ArrayList<String> strings = new ArrayList<>();

        while (reader.ready()) {
            strings.add(reader.readLine());
        }

        inputStream.close();
        reader.close();

        int needId = Integer.parseInt(args[0]);

        for (String s : strings) {
            String[] info = s.split(" ", 2);
            int id = Integer.parseInt(info[0]);
            if (id != needId)
                continue;
            System.out.println(s);
//            int quantity = Integer.parseInt(info[info.length - 1]);
//            double price = Double.parseDouble(info[info.length - 2]);
//            String productName = "";
//            for (int i = 1; i < info.length - 2; i++) productName += info[i] + " ";
//            System.out.format("%d %s %s %d", id, productName.trim(), String.valueOf(price), quantity);
        }
    }
}
