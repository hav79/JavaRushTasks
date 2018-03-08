package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename1 = scanner.nextLine();
        String filename2 = scanner.nextLine();
        String filename3 = scanner.nextLine();

        FileOutputStream outputStream = new FileOutputStream(filename1);
        FileInputStream inputStream1 = new FileInputStream(filename2);
        FileInputStream inputStream2 = new FileInputStream(filename3);

        while (inputStream1.available() > 0) outputStream.write(inputStream1.read());
        while (inputStream2.available() > 0) outputStream.write(inputStream2.read());

        outputStream.close();
        inputStream1.close();
        inputStream2.close();
    }
}
