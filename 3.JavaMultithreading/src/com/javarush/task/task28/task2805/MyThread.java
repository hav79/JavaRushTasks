package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private static AtomicInteger nextPriority = new AtomicInteger(1);

    public MyThread() {
        super();
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (nextPriority.get() > 10)
            nextPriority.set(1);
        setPriority(nextPriority.getAndIncrement());
    }
}
