package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        String answer = "";
        while (true) {
            writeMessage("Выберите блюдо:");
            writeMessage(Dish.allDishesToString());
            answer = readString();
            if (answer.equals("exit"))
                break;
            try {
                dishes.add(Dish.valueOf(answer));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет");
            }
        }
        return dishes;
    }
}
