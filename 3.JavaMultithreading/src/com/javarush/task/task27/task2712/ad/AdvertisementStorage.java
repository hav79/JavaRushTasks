package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    public static AdvertisementStorage getInstance() {
        return instance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
//        add(new Advertisement(someContent, "Null Video", 300, 0, 20 * 60)); //20 min
//        add(new Advertisement(someContent, "Fourth Video", 800, 5, 12 * 60)); //12 min
//        add(new Advertisement(someContent, "Fifth Video", 600, 7, 8 * 60)); //8 min
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
