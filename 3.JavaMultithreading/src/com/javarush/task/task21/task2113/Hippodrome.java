package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Hippodrome {
        private List<Horse> horses;
        static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        game = new Hippodrome(horses);
        game.getHorses().add(new Horse("Horse 1", 3, 0));
        game.getHorses().add(new Horse("Horse 2", 3, 0));
        game.getHorses().add(new Horse("Horse 3", 3, 0));
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);
        IntStream.range(0, 10).forEach(i -> System.out.println());
    }

    public Horse getWinner() {
        return horses.stream().max(Comparator.comparingDouble(Horse::getDistance)).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
