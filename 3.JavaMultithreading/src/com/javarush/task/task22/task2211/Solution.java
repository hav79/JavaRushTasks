package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[1024];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
            String s = new String(buffer, Charset.forName("windows-1251"));
            outputStream.write(s.getBytes(Charset.forName("UTF-8")));
        }

        inputStream.close();
        outputStream.close();
    }
}
