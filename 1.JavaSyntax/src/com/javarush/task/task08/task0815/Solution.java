package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Иван");
        map.put("Сидоров", "Сергей");
        map.put("Хромов", "Александр");
        map.put("Третьяков", "Василий");
        map.put("Василюк", "Александр");
        map.put("Сурнин", "Денис");
        map.put("Сергеев", "Олег");
        map.put("Максимов", "Алексей");
        map.put("Чернов", "Олег");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s : map.values())
            if (s.equals(name))
                count++;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        return 1;
    }

    public static void main(String[] args) {

    }
}
