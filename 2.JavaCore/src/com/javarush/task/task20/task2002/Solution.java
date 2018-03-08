package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User user1 = new User("Ivan", "Ivanov",
//                    new SimpleDateFormat("dd.MM.yyyy").parse("25.06.1986"),
//                    true, User.Country.RUSSIA);
//            User user2 = new User("Anna", "Petrova",
//                    new SimpleDateFormat("dd.MM.yyyy").parse("25.06.1986"),
//                    false, User.Country.UKRAINE);
//            javaRush.users.add(user1);
//            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            for (User user : users) {
                outputStream.write(user.toString().getBytes());
                outputStream.write('\n');
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            StringBuilder s = new StringBuilder();
            while (inputStream.available() > 0) s.append((char) inputStream.read());
            if (s.toString().isEmpty()) return;
            String[] usersList = s.toString().split("\n");
            for (String s1 : usersList) {
                String[] userAr = s1.split(":");
                User user = new User();
                user.setFirstName(userAr[0]);
                user.setLastName(userAr[1]);
                user.setBirthDate(new Date(Long.parseLong(userAr[2])));
                user.setMale(userAr[3].equals("true"));
                user.setCountry(User.Country.valueOf(userAr[4].toUpperCase()));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
