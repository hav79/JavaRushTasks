package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    //напишите тут ваш код
    String name;
    int height;
    String color;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int height) {
        this(name);
        this.height = height;
    }

    public Dog(String name, int height, String color) {
        this(name, height);
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
