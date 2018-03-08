package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String inFilename = scanner.nextLine();
        String outFilename = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(inFilename);
        FileOutputStream outputStream = new FileOutputStream(outFilename);

        ArrayList<Integer> bytes = new ArrayList<>();

        while (inputStream.available() > 0)
            bytes.add(inputStream.read());

        for (int i = bytes.size()-1; i >= 0; i--)
            outputStream.write(bytes.get(i));

        inputStream.close();
        outputStream.close();
    }
}
