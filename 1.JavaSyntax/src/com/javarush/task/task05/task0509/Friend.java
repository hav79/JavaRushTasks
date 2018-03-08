package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    //напишите тут ваш код
    String name;
    int age;
    char sex;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int age) {
        initialize(name);
        this.age = age;
    }

    public void initialize(String name, int age, char sex) {
        initialize(name, age);
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
