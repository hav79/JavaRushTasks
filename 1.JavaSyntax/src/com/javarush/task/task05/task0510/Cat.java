package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public void initialize(String name) {
        this.name = name;
        this.weight = 5;
        this.age = 3;
        this.color = "black";
    }

    public void initialize(String name, int weight, int age) {
        initialize(name);
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, int age) {
        initialize(name, 5, age);
    }

    public void initialize(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 3;
    }

    public void initialize(int weight, String color, String address) {
        initialize(weight, color);
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
