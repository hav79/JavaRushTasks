package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String params = url.substring(url.indexOf("?")+1);
        String[] paramList = params.split("&");
        String obj = null;
        for (int i = 0; i < paramList.length; i++) {
            String[] param = paramList[i].split("=");
            System.out.print(param[0] + " ");
            if ("obj".equals(param[0]))
                obj = param[1];
        }
        if (obj != null) {
            System.out.println();
            try {
                double d = Double.parseDouble(obj);
                alert(d);
            } catch (Exception e) {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
