package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human momsGrandfather = new Human();
        momsGrandfather.name = "ded";
        momsGrandfather.age = 75;
        momsGrandfather.sex = true;
        
        Human momsGrandmother = new Human();
        momsGrandmother.name = "bab";
        momsGrandmother.age = 70;
        momsGrandmother.sex = false;

        Human dadsGrandfather = new Human();
        dadsGrandfather.name = "ded2";
        dadsGrandfather.age = 73;
        dadsGrandfather.sex = true;

        Human dadsGrandmother = new Human();
        dadsGrandmother.name = "bab2";
        dadsGrandmother.age = 74;
        dadsGrandmother.sex = false;

        Human father = new Human();
        father.name = "pap";
        father.age = 34;
        father.sex = true;
        dadsGrandfather.children.add(father);
        dadsGrandmother.children.add(father);

        Human mother = new Human();
        mother.name = "mam";
        mother.age = 30;
        mother.sex = false;
        momsGrandfather.children.add(mother);
        momsGrandmother.children.add(mother);

        Human son1 = new Human();
        son1.name = "son1";
        son1.age = 14;
        son1.sex = true;

        Human son2 = new Human();
        son2.name = "son2";
        son2.age = 9;
        son2.sex = true;

        Human daughter = new Human();
        daughter.name = "ddd";
        daughter.age = 4;
        daughter.sex = false;

        father.children.add(son1);
        father.children.add(son2);
        father.children.add(daughter);
        mother.children.add(son1);
        mother.children.add(son2);
        mother.children.add(daughter);

        System.out.println(dadsGrandfather);
        System.out.println(dadsGrandmother);
        System.out.println(momsGrandfather);
        System.out.println(momsGrandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
