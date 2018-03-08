package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = conReader.readLine();
        conReader.close();

        StringBuilder str = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.ready()) {
            str.append(reader.readLine());
        }
        reader.close();

        ArrayList<Integer> openTags = new ArrayList<>();
        ArrayList<Integer> closeTags = new ArrayList<>();
        Pattern openTagPattern = Pattern.compile("<" + args[0]);
        Pattern closeTagPattern = Pattern.compile("</" + args[0] + ">");
        Matcher openMatcher = openTagPattern.matcher(str.toString());
        Matcher closeMatcher = closeTagPattern.matcher(str.toString());
        int pos = 0;
        while (openMatcher.find(pos)) {
            openTags.add(openMatcher.start());
            pos = openMatcher.start() + 1;
        }
        pos = 0;
        while (closeMatcher.find(pos)) {
            closeTags.add(closeMatcher.end());
            pos = closeMatcher.end();
        }

        ArrayList<String> result = new ArrayList<>();

        int p;
        for (Integer openTag : openTags) {
            Iterator<Integer> it = closeTags.iterator();
            int closeTag;
            while ((closeTag = it.next()) <= openTag) {}
            if (str.substring(openTag + 1, closeTag).contains("<" + args[0]))
                closeTag = it.next();
            result.add(str.substring(openTag, closeTag));
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
