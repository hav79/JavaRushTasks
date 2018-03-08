package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, Integer> names = new HashMap<>();
        for (String s : map.values()) {
            if (names.containsKey(s))
                names.put(s, names.get(s) + 1);
            else
                names.put(s, 1);
        }
        for (Map.Entry<String, Integer> entry : names.entrySet())
            if (entry.getValue() > 1)
                removeItemFromMapByValue(map, entry.getKey());
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
