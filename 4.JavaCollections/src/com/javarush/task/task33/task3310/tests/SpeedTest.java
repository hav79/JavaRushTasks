package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long time = 0;
        for (String string : strings) {
            Date start = new Date();
            Long id = shortener.getId(string);
            Date end = new Date();
            ids.add(id);
            time += end.getTime() - start.getTime();
        }
        return time;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long time = 0;
        for (Long id : ids) {
            Date start = new Date();
            String s = shortener.getString(id);
            Date end = new Date();
            strings.add(s);
            time += end.getTime() - start.getTime();
        }
        return time;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10_000; i++)
            origStrings.add(Helper.generateRandomString());

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);

        Set<String> strings1 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();
        time1 = getTimeForGettingStrings(shortener1, ids1, strings1);
        time2 = getTimeForGettingStrings(shortener2, ids2, strings2);
        Assert.assertEquals(time1, time2, 30);
    }
}
