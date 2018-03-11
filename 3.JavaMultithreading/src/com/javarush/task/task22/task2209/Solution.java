package com.javarush.task.task22.task2209;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<String> words = new ArrayList<>();
        lines.stream().map(line -> Arrays.asList(line.split(" "))).forEach(words::addAll);
        StringBuilder result = getLine(words.toArray(new String[words.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder s = new StringBuilder();
        if (words.length == 0) return s;
        LinkedList<String> result = new LinkedList<>();
        ArrayList<String> other = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i];
            String first = result.getFirst().toLowerCase();
            String last = result.getLast().toLowerCase();
            if (s1.toLowerCase().startsWith(last.substring(last.length() - 1)))
                result.add(s1);
            else if (s1.toLowerCase().endsWith(first.substring(0, 1)))
                result.addFirst(s1);
            else other.add(s1);
        }
        result.stream().map(s1 -> s1 + " ").forEach(s::append);
        other.stream().map(s1 -> s1 + " ").forEach(s::append);
        return s;
    }
}
