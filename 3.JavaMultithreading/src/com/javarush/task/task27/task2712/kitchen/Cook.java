package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();


    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (!isBusy()) {
                if (!queue.isEmpty()) {
                    startCookingOrder(queue.poll());
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order +
                ", cooking time " + order.getTotalCookingTime() + "min");
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Tablet) o).toString(),
//                name, order.getTotalCookingTime() * 60, order.getDishes()));
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {

        }
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return name;
    }
}
