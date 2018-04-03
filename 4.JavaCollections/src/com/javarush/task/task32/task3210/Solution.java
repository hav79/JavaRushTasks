package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long pos = Long.parseLong(args[1]);
        raf.seek(pos);
        String testText = args[2];
        byte[] text = new byte[testText.length()];
        raf.read(text, 0, testText.length());
        raf.seek(raf.length());
        String str = new String(text);
        if (str.equals(testText))
            raf.write("true".getBytes());
        else
            raf.write("false".getBytes());

    }
}
