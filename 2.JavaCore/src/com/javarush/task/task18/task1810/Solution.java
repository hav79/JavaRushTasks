package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        Scanner scanner = new Scanner(System.in);
        String filename = "";
        FileInputStream inputStream;
        while (true) {
            filename = scanner.nextLine();
            inputStream = new FileInputStream(filename);
            if (inputStream.available() < 1000)
                throw new DownloadException();
            inputStream.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
