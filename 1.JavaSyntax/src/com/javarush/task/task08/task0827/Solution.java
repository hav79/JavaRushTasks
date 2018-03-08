package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d yyyy");
//        Date date1 = dateFormat.parse(date);
        Date date1 = new Date(date);
//        Date start_year = dateFormat.parse(date);
        Date start_year = new Date(date);
        start_year.setMonth(0);
        start_year.setDate(1);
        long days = (date1.getTime() - start_year.getTime()) / (24 * 60 * 60 * 1000);

        return days % 2 == 0;
    }
}
