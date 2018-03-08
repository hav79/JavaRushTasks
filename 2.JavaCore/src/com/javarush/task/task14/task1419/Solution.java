package com.javarush.task.task14.task1419;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NullPointerException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new CharConversionException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new NoSuchMethodException());

    }
}
