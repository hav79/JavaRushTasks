package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 200);
        map.put("Петров", 860);
        map.put("Сидоров", 1500);
        map.put("Хромов", 2500);
        map.put("Третьяков", 950);
        map.put("Василюк", 360);
        map.put("Сурнин", 463);
        map.put("Сергеев", 874);
        map.put("Максимов", 1000);
        map.put("Чернов", 630);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() < 500)
                iter.remove();
        }
    }

    public static void main(String[] args) {

    }
}