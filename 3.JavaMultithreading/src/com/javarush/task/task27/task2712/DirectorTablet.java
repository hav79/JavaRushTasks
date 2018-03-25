package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<String, Long> profit = StatisticManager.getInstance().getAdvertisementProfit();
        double total = 0.0;
        for (Map.Entry<String, Long> entry : profit.entrySet()) {
            ConsoleHelper.writeMessage(
                    String.format("%s - %.2f", entry.getKey(), entry.getValue().doubleValue() / 100));
            total += entry.getValue().doubleValue() / 100;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> workload = StatisticManager.getInstance().getCooksWorkload();
        for (Map.Entry<String, Map<String, Integer>> entry : workload.entrySet()) {
            ConsoleHelper.writeMessage(entry.getKey());
            Map<String, Integer> dayWorkload = new  TreeMap<>(entry.getValue());
            for (Map.Entry<String, Integer> integerEntry : dayWorkload.entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min",
                        integerEntry.getKey(), integerEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance().getActiveVideos()
                .stream()
                .map(ad -> String.format("%s - %d", ad.getName(), ad.getHits()))
                .forEach(ConsoleHelper::writeMessage);
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance().getArchivedVideos()
                .stream()
                .map(Advertisement::getName)
                .forEach(ConsoleHelper::writeMessage);
    }
}
