package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        try (BufferedReader bufReader1 = new BufferedReader(new FileReader(filename1));
                BufferedReader bufReader2 = new BufferedReader(new FileReader(filename2))) {

            ArrayList<String> lines1 = new ArrayList<>();
            ArrayList<String> lines2 = new ArrayList<>();

            while (bufReader1.ready())
                lines1.add(bufReader1.readLine());
            while (bufReader2.ready())
                lines2.add(bufReader2.readLine());

            int i, j;
            for (i = 0, j = 0; i < lines1.size() && j < lines2.size(); ) {
                String s1 = lines1.get(i);
                String s1next = i == lines1.size() - 1 ? "" : lines1.get(i + 1);
                String s2 = lines2.get(j);
                String s2next = j == lines2.size() - 1 ? "" : lines2.get(j + 1);
                if (s1.equals(s2)) {
                    lines.add(new LineItem(Type.SAME, s1));
                    i++;
                    j++;
                } else if (s1.equals(s2next)) {
                    lines.add(new LineItem(Type.ADDED, s2));
                    j++;
                } else if (s2.equals(s1next)) {
                    lines.add(new LineItem(Type.REMOVED, s1));
                    i++;
                }
            }

            if (j == lines2.size())
                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
            else if (i == lines1.size())
                lines.add(new LineItem(Type.ADDED, lines2.get(j)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
