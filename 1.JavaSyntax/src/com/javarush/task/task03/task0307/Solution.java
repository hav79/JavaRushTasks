package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg[] zergs = new Zerg[10];
        for (int i = 0; i < 10; i++) {
            zergs[i] = new Zerg();
            zergs[i].name = "Zerg" + i;
        }
        Protoss[] protosses = new Protoss[5];
        for (int i = 0; i < 5; i++) {
            protosses[i] = new Protoss();
            protosses[i].name = "Protoss" + i;
        }

        Terran[] terrans = new Terran[12];
        for (int i = 0; i < 12; i++) {
            terrans[i] = new Terran();
            terrans[i].name = "Terran" + i;
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
