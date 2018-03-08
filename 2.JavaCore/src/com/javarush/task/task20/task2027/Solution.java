package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> words = detectAllWords(crossword, "home", "same");
        for ( Word word : words) System.out.println(word);


        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> result = new ArrayList<>();
        for (String w : words) {

            char c = w.charAt(0);
            char c2 = w.charAt(1);
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    if (crossword[i][j] == c) {
                        Word word;
                        if ((word = findWord(crossword, w, i, j)) != null)
                            result.add(word);
                    }
                }
            }

        }

        return null;
    }

    /*
    1. взять точку с первым символом.
    2. обойти все точки вокруг, искать второй символ, все найденные точки в очередь
    3. брать очередную точку из очереди, искать вокруг следующий символ, добавлять в очередь
    4. выполнять пока не найден последний символ

    в очереди - следующий символ, координаты текущей точки
     */

    private static Word findWord(int[][] cross, String w, int i, int j) {
        char c2 = w.charAt(1);
        int vectI = 0;
        int vectJ = 0;
        try { if (cross[i][j + 1] == c2) { vectI = 0; vectJ = 1; } } catch (Exception e) {}
        try { if (cross[i + 1][j + 1] == c2) { vectI = 1; vectJ = 1; } } catch (Exception e) {}
        try { if (cross[i + 1][j] == c2) { vectI = 1; vectJ = 0; } } catch (Exception e) {}
        try { if (cross[i + 1][j - 1] == c2) { vectI = 1; vectJ = -1; } } catch (Exception e) {}
        try { if (cross[i][j - 1] == c2) { vectI = 0; vectJ = -1; } } catch (Exception e) {}
        try { if (cross[i - 1][j - 1] == c2) { vectI = -1; vectJ = -1; } } catch (Exception e) {}
        try { if (cross[i - 1][j] == c2) { vectI = -1; vectJ = 0; } } catch (Exception e) {}
        try { if (cross[i - 1][j + 1] == c2) { vectI = -1; vectJ = 1; } } catch (Exception e) {}
        if (vectI == 0 && vectJ == 0) {
            return null;
        }
        Word word = new Word(w);
        word.setStartPoint(i, j);
        word.setEndPoint(i + vectI * (w.length() + 1), j + vectJ * (w.length() + 1));

        return word;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
