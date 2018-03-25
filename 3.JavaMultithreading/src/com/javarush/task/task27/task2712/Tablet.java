package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {

    final int number;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            return getOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public void createTestOrder() {
        try {
            Order order = new TestOrder(this);
            getOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private Order getOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        if (!order.isEmpty()) {
            try {
                queue.put(order);
                manager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            } catch (InterruptedException e) {

            }
        }
        return order;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}
