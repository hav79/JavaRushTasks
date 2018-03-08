package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length-2; i=i+3) {
                        if (args[i+1].equals("м"))
                            allPeople.add(Person.createMale(args[i], dateFormat.parse(args[i+2])));
                        else
                            allPeople.add(Person.createFemale(args[i], dateFormat.parse(args[i+2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length-3; i=i+4) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(args[i+1]);
                        allPeople.get(index).setSex(args[i+2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        allPeople.get(index).setBirthDay(dateFormat.parse(args[i+3]));
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setSex(null);
                        allPeople.get(index).setBirthDay(null);
                    }
                }
                break;
            case "-i":
                SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        String sex = p.getSex() == Sex.MALE ? "м" : "ж";
                        System.out.println(p.getName() + " " + sex + " " + outDateFormat.format(p.getBirthDay()));
                    }
                }
                break;
        }

    }
}