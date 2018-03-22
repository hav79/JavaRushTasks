package com.javarush.task.task28.task2803;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(n);
    }

    public static void main(String[] args) {
        System.out.println(getRandomIntegerBetweenNumbers(1, 5));
        System.out.println(getRandomIntegerBetweenNumbers(10, 50));
        System.out.println(getRandomIntegerBetweenNumbers(20, 30));

        System.out.println(getRandomDouble());
        System.out.println(getRandomDouble());
        System.out.println(getRandomDouble());

        System.out.println(getRandomLongBetween0AndN(10));
        System.out.println(getRandomLongBetween0AndN(25));
        System.out.println(getRandomLongBetween0AndN(100));
    }
}
