package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        Helper.printMessage("------------------------");
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        Helper.printMessage("------------------------");
        testStrategy(new FileStorageStrategy(), 100);
        Helper.printMessage("------------------------");
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
        Helper.printMessage("------------------------");
        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        Helper.printMessage("------------------------");
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream()
                .map(shortener::getId)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream()
                .map(shortener::getString)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date end = new Date();
        Helper.printMessage(String.valueOf(end.getTime() - start.getTime()));

        start = new Date();
        Set<String> newStrings = getStrings(shortener, ids);
        end = new Date();
        Helper.printMessage(String.valueOf(end.getTime() - start.getTime()));

        if (strings.equals(newStrings))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
