package com.javarush.task.task25.task2511;

import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t, e) -> {
            String err = e.getMessage();
            String stars = IntStream.range(0, t.getName().length()).mapToObj(i -> "*").collect(Collectors.joining());
            System.out.println(err.replaceAll(t.getName(), stars));
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution s = new Solution(null);
    }
}