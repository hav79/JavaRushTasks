package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomOrderGeneratorTask implements Runnable {

    List<Tablet> tablets;
    int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int number = ThreadLocalRandom.current().nextInt(tablets.size());
                Tablet tablet = tablets.get(number);
                tablet.createTestOrder();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
