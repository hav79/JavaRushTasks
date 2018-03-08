package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int n, String value) {
        printMatrix(n, n, (Object) value);
    }

    public static void printMatrix(int n, Object value) {
        printMatrix(n, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int value) {
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int n, int value) {
        printMatrix(n, n, (Object) value);
    }

    public static void printMatrix(int m, int n, double value) {
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int n, double value) {
        printMatrix(n, n, (Object) value);
    }

    public static void printMatrix(int m, int n, String s1, String s2) {
        printMatrix(m, n, (Object) s1);
        printMatrix(m, n, (Object) s2);
    }

    public static void printMatrix(int n, String s1, String s2) {
        printMatrix(n, n, (Object) s1);
        printMatrix(n, n, (Object) s2);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
