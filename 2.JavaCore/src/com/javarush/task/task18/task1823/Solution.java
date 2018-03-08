package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String filename = scanner.nextLine();
            if (filename.equals("exit")) break;
            new ReadThread(filename).start();
        }

    }

    public static class ReadThread extends Thread {
        private String filename;
        private HashMap<Integer, Integer> counts = new HashMap<>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.filename = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream inputStream = new FileInputStream(filename)) {

                while (inputStream.available() > 0) {
                    int b = inputStream.read();
                    int count = counts.getOrDefault(b, 0);
                    counts.put(b, count + 1);
                }

                int symbol = 0;
                int maxCount = Integer.MIN_VALUE;
                for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry.getValue();
                        symbol = entry.getKey();
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(filename, symbol);
                }
            } catch (IOException e) {  }
        }
    }
}
