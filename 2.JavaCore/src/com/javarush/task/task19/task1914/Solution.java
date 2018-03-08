package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));

        testString.printSomething();

        String s = outputStream.toString();
        String[] s1 = s.split(" ");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[2]);
        String sign = s1[1];
        int result;
        switch (sign) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                result = 0;
        }

        System.setOut(console);
        System.out.println(String.format("%d %s %d = %d", a, sign, b, result));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

