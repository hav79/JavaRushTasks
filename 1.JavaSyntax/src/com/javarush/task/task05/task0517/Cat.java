package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(String name) {
        this.name = name;
        this.weight = 5;
        this.age = 3;
        this.color = "black";
    }

    public Cat(String name, int weight, int age) {
        this(name);
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {
        this(name, 5, age);
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 3;
    }

    public Cat(int weight, String color, String address) {
        this(weight, color);
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
