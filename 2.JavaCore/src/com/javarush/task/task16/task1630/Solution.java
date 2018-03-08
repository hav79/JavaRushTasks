package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        Scanner scanner = new Scanner(System.in);
        firstFileName = scanner.nextLine();
        secondFileName = scanner.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private StringBuilder fileContent = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            return fileContent.toString();
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                reader.lines().forEach(it -> fileContent.append(String.format("%s ", it)));
                reader.close();
            } catch (IOException e) {  }
        }
    }

    //add your code here - добавьте код тут
}
