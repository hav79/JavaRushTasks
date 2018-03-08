package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private String address;
        private Human mother;
        private Human father;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(String name, Human mother, Human father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, boolean sex, String address) {
            this.name = name;
            this.sex = sex;
            this.address = address;
        }

        public Human(String name, int age, boolean sex, String address, Human mother, Human father) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.mother = mother;
            this.father = father;
        }
    }
}
