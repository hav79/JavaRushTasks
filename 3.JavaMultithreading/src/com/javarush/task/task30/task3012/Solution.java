package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] powers = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder result = new StringBuilder().append(number).append(" = ");
        int power = 0;
        while (number >= 3) {
            int mod = number % 3;
            number /= 3;
            if (mod == 2) number++;
            switch (mod) {
                case 0:
                    power++;
                    break;
                case 1:
                    result.append(" + ").append(powers[power++]);
                    break;
                case 2:
                    result.append(" - ").append(powers[power++]);
            }
        }
        switch (number) {
            case 0:
                power++;
                break;
            case 1:
                result.append(" + ").append(powers[power++]);
                break;
            case 2:
                result.append(" - ").append(powers[power++]);
                result.append(" + ").append(powers[power++]);
        }
        System.out.println(result.toString());
    }
}