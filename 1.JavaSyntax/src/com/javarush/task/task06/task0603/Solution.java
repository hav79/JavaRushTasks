package com.javarush.task.task06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 1000000; i++) {
//            Dog dog = new Dog();
            Cat cat = new Cat();
        }
        System.gc();
        System.out.println("Created: " + Cat.count);
        System.out.println("Killed: " + Cat.killed);
    }
}

class Cat {
    public static int count = 0;
    public static int killed = 0;

    public Cat() {
        count++;
    }

    @Override
    protected void finalize() throws Throwable {
        killed++;
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
