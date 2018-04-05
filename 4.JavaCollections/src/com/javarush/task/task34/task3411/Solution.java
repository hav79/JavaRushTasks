package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
        if (count == 1)
            System.out.format("from %s to %s%n", a, b);
        else {
            moveRing(a, c, b, count - 1);
            moveRing(a, b, c, 1);
            moveRing(c, b, a, count - 1);
        }
    }
}