package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String s = reader.readLine();
            String[] line = s.split(" ");
            StringBuilder nameBiulder = new StringBuilder();
            for (int i = 0; i < line.length - 3; i++) nameBiulder.append(line[i]).append(" ");
            String name = nameBiulder.toString().trim();
            int day = Integer.parseInt(line[line.length - 3]);
            int month = Integer.parseInt(line[line.length - 2]);
            int year = Integer.parseInt(line[line.length - 1]);
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.YEAR, year);
            PEOPLE.add(new Person(name, calendar.getTime()));
        }
        reader.close();
    }
}
