package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideos() {
        return storage.list()
                .stream()
                .filter((ad) -> ad.getHits() > 0)
                .sorted((ad1, ad2) -> ad1.getName().compareToIgnoreCase(ad2.getName()))
                .collect(Collectors.toList());
    }

    public List<Advertisement> getArchivedVideos() {
        return storage.list()
                .stream()
                .filter((ad) -> ad.getHits() == 0)
                .sorted((ad1, ad2) -> ad1.getName().compareToIgnoreCase(ad2.getName()))
                .collect(Collectors.toList());
    }


}
