package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filename1 = scanner.nextLine();
        String filename2 = scanner.nextLine();

        BufferedReader reader1;
        BufferedReader reader2;
        String line;

        try {
            reader1 = new BufferedReader(new FileReader(filename1));
            reader2 = new BufferedReader(new FileReader(filename2));
            while ((line = reader1.readLine()) != null) allLines.add(line);
            while ((line = reader2.readLine()) != null) forRemoveLines.add(line);
            reader1.close();
            reader2.close();
        } catch (IOException e) { }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) { }
          catch (IOException e) {  }
    }

    public void joinData() throws IOException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
