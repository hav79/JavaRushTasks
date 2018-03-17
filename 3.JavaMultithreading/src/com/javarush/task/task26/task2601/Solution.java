package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int mediana;
        int halfLength = array.length / 2;
        if (array.length % 2 != 0)
            mediana = array[halfLength];
        else
            mediana = (array[halfLength - 1] + array[halfLength]) / 2;
        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs(o - mediana)));
        return array;
    }
}
