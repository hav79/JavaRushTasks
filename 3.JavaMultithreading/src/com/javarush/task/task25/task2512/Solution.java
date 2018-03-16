package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> errors = new ArrayList<>();
        errors.add(e);
        Throwable cause = e;
        while ((cause = cause.getCause()) != null)
            errors.add(cause);
        for (int i = errors.size() - 1; i >= 0; i--) {
            System.out.println(errors.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
