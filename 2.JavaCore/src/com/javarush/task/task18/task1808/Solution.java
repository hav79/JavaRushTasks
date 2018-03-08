package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String inFilename = scanner.nextLine();
        String outFilename1 = scanner.nextLine();
        String outFilename2 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(inFilename);
        FileOutputStream outputStream1 = new FileOutputStream(outFilename1);
        FileOutputStream outputStream2 = new FileOutputStream(outFilename2);

        int fileSize = inputStream.available();
        System.out.println(fileSize);
        while (inputStream.available() > 0) {
            if (inputStream.available() > fileSize/2)
                outputStream1.write(inputStream.read());
            else
                outputStream2.write(inputStream.read());
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
