package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov"/*, new Asset("home", 999_999.99), new Asset("car", 2999.99)*/);
            System.out.println(ivanov);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", assets=" + assets +
                    '}';
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            outputStream.write(name.getBytes());
            if (!assets.isEmpty()) {
                String as = assets.stream()
                        .map(Asset::toString)
                        .collect(Collectors.joining(";", "(", ")"));
                outputStream.write(as.getBytes());
            }
            else
                outputStream.write("()".getBytes());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            StringBuilder s = new StringBuilder();
            while (inputStream.available() != 0) s.append((char) inputStream.read());
            name = s.substring(0, s.indexOf("("));
            String as = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            if (!as.isEmpty()) {
                String[] asAr = as.split(";");
                for (String s1 : asAr) {
                    String[] as1 = s1.split(":");
                    Asset asset = new Asset(as1[0], Double.parseDouble(as1[1]));
                    assets.add(asset);
                }
            }
        }
    }
}
