package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while (true) {
                int num = Integer.parseInt(reader.readLine());
                list.add(num);
            }
        } catch (NumberFormatException e) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (IOException e) {

        }
    }
}
