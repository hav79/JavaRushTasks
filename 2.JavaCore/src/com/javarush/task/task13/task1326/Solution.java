package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();

        ArrayList<Integer> nums = new ArrayList<>();

        InputStream fileStream = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            int num = Integer.parseInt(line);
            if (num % 2 == 0)
                nums.add(num);
        }
        fileStream.close();
        reader.close();
        Collections.sort(nums);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}
