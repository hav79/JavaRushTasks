package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread t = new TestThread();
        t.start();
        t.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        @Override
        public void run() {
            int x = 0;
            for (int i = 0; i < 100000; i++) {
                x++;
            }
        }
    }
}