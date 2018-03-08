package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        Random r = new Random();
        while (set.size() < 20)
            set.add(r.nextInt(100));
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        HashSet<Integer> new_set = new HashSet<>();
        for (Integer item : set) {
            if (item <= 10)
                new_set.add(item);
        }
        return new_set;
    }

    public static void main(String[] args) {

    }
}
