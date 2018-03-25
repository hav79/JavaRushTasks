package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Thread cook1Thread = new Thread(cook1);
        cook1Thread.setDaemon(true);
        cook1Thread.start();
        Cook cook2 = new Cook("SuperCook");
        cook2.setQueue(orderQueue);
        Thread cook2Thread = new Thread(cook2);
        cook2Thread.setDaemon(true);
        cook2Thread.start();
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
