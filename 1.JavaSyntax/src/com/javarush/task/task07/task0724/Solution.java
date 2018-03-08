package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human momGrandFather = new Human("Коля", true, 65);
        Human momGrandMother = new Human("Надя", false, 63);
        Human dadGrandFather = new Human("Миша", true, 74);
        Human dadGrandMother = new Human("Катя", false, 68);
        Human father = new Human("Вася", true, 39, dadGrandFather, dadGrandMother);
        Human mother = new Human("Оля", false, 35, momGrandFather, momGrandMother);
        Human son1 = new Human("Максим", true, 15, father, mother);
        Human son2 = new Human("Гриша", true, 10, father, mother);
        Human daughter = new Human("Ира", false, 5, father, mother);

        System.out.println(momGrandFather);
        System.out.println(momGrandMother);
        System.out.println(dadGrandFather);
        System.out.println(dadGrandMother);
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
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















