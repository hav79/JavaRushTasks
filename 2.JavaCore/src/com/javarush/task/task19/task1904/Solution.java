package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("/home/hav/test.txt"));
        PersonScannerAdapter scannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(scannerAdapter.read());
        System.out.println(scannerAdapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            Calendar date = new GregorianCalendar();
            date.set(Calendar.DAY_OF_MONTH, fileScanner.nextInt());
            date.set(Calendar.MONTH, fileScanner.nextInt() - 1);
            date.set(Calendar.YEAR, fileScanner.nextInt());

            Person person = new Person(firstName, middleName, lastName, date.getTime());

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
