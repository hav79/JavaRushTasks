package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        HashMap<String, Date> map = new HashMap<String, Date>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        map.put("Stallone", dateFormat.parse("01.06.1980"));
        map.put("Иванов", dateFormat.parse("05.06.1984"));
        map.put("Петров", dateFormat.parse("23.08.1975"));
        map.put("Сидоров", dateFormat.parse("12.11.1994"));
        map.put("Хромов", dateFormat.parse("24.09.1979"));
        map.put("Третьяков", dateFormat.parse("11.05.1986"));
        map.put("Чернов", dateFormat.parse("14.03.1987"));
        map.put("Белов", dateFormat.parse("06.07.1980"));
        map.put("Петренко", dateFormat.parse("09.08.1981"));
        map.put("Иваненко", dateFormat.parse("22.04.1982"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        int month;
        while (iter.hasNext()) {
            Date date = iter.next().getValue();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            month = localDate.getMonthValue();
            if (month > 5 && month < 9)
                iter.remove();
        }
    }

    public static void main(String[] args) throws ParseException {

    }
}
