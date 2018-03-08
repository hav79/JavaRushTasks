package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if ("-c".equals(args[0]))
            addPerson(args[1], args[2], args[3]);
        else if ("-u".equals(args[0]))
            updatePerson(args[1], args[2], args[3], args[4]);
        else if ("-d".equals(args[0]))
            deletePerson(args[1]);
        else if ("-i".equals(args[0]))
            showPerson(args[1]);
    }

    public static void addPerson(String name, String sex, String bd) {
        try {
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, dateFormat.parse(bd)));
            else
                allPeople.add(Person.createFemale(name, dateFormat.parse(bd)));
        } catch (ParseException e) {  }
        System.out.println(allPeople.size() - 1);
    }

    private static void updatePerson(String id, String name, String sex, String bd) {
        int index = Integer.parseInt(id);
        allPeople.get(index).setName(name);
        allPeople.get(index).setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
        try {
            allPeople.get(index).setBirthDay(dateFormat.parse(bd));
        } catch (ParseException e) {   }
    }

    private static void deletePerson(String id) {
        int index = Integer.parseInt(id);
        allPeople.get(index).setName(null);
        allPeople.get(index).setSex(null);
        allPeople.get(index).setBirthDay(null);
    }

    private static void showPerson(String id) {
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Person p = allPeople.get(Integer.parseInt(id));
        String sex = p.getSex() == Sex.MALE ? "м" : "ж";
        System.out.println(p.getName() + " " + sex + " " + outDateFormat.format(p.getBirthDay()));
    }
}
