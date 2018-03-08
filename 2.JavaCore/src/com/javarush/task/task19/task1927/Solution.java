package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();

        System.setOut(console);

        boolean needOutText = false;
        String[] str = stream.toString().split("\\n");
        for (String s : str) {
            System.out.println(s);
            if (needOutText)
                System.out.println("JavaRush - курсы Java онлайн");
            needOutText = !needOutText;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
