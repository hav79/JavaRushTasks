package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> digits = new HashMap<Character, Integer>();
        digits.put('I', 1); digits.put('V', 5);
        digits.put('X', 10); digits.put('L', 50);
        digits.put('C', 100); digits.put('D', 500);
        digits.put('M', 1000);

        int sum = 0;
        int previous = digits.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int current = digits.get(s.charAt(i));
            if (current <= previous)
                sum += previous;
            else
                sum -= previous;
            previous = current;
        }
        sum += previous;
        return sum;
    }
}
