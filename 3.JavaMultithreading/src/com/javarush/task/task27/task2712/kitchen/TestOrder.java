package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        List<Dish> tempDishes = new ArrayList<>(Arrays.asList(Dish.values()));
        Collections.shuffle(tempDishes);
        int countDishes = 1 + ThreadLocalRandom.current().nextInt(Dish.values().length - 1);
        dishes = tempDishes.subList(0, countDishes);
    }
}
