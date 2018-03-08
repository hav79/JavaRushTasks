package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listDiv3 = new ArrayList<>();
        ArrayList<Integer> listDiv2 = new ArrayList<>();
        ArrayList<Integer> listOther = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            list.add(Integer.parseInt(reader.readLine()));
        for (Integer aList : list) {
            if (aList % 3 == 0)
                listDiv3.add(aList);
            if (aList % 2 == 0)
                listDiv2.add(aList);
            if (aList % 3 != 0 && aList % 2 != 0)
                listOther.add(aList);
        }
        printList(listDiv3);
        printList(listDiv2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer aList : list)
            System.out.println(aList);
    }
}
