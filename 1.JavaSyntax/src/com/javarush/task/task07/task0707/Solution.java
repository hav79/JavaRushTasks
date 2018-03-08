package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ffwfw");
        strings.add("fgerwfwf");
        strings.add("ppmfw");
        strings.add("gegwf");
        strings.add("mkfwnf");
        System.out.println(strings.size());
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
