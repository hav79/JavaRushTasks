package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static void main(String[] args) {
    }


    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getClass().getName());
            }
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        boolean isCanceled;
        @Override
        public void run() {
            while (!isCanceled) {
            }
        }

        @Override
        public void showWarning() {
            isCanceled = true;
        }
    }

    public static class ThreadFive extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            while (true) {
                String s = scanner.nextLine();
                if (!"N".equals(s))
                    sum += Integer.parseInt(s);
                else {
                    System.out.println(sum);
                    break;
                }
            }
        }
    }
}