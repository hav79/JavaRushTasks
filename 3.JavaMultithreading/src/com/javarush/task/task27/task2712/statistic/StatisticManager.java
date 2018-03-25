package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getAdvertisementProfit() {
        Map<String, Long> profit = new TreeMap<>(Comparator.reverseOrder());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        for (EventDataRow event : statisticStorage.getEvents(EventType.SELECTED_VIDEOS)) {
            String strDate = dateFormat.format(event.getDate());
            long amount = ((VideoSelectedEventDataRow) event).getAmount();
            long dayProfit = profit.getOrDefault(strDate, 0L);
            profit.put(strDate, dayProfit + amount);
        }
        return profit;
    }

    public Map<String, Map<String, Integer>> getCooksWorkload() {
        Map<String, Map<String, Integer>> workload = new TreeMap<>(Comparator.reverseOrder());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        for (EventDataRow event : statisticStorage.getEvents(EventType.COOKED_ORDER)) {
            String date = dateFormat.format(event.getDate());
            String cookName = ((CookedOrderEventDataRow) event).getCookName();
            int cookingTime = event.getTime() / 60;
            Map<String, Integer> dayWorkload = workload.getOrDefault(date, new HashMap<>());
            int cookDayWorkload = dayWorkload.getOrDefault(cookName, 0);
            dayWorkload.put(cookName, cookDayWorkload + cookingTime);
            workload.put(date, dayWorkload);
        }
        return workload;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType type) {
            return storage.get(type);
        }
    }
}
