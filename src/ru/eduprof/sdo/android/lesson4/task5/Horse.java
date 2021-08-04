package ru.eduprof.sdo.android.lesson4.task5;

public class Horse extends Animal {
    String breed;
    String color;

    public Horse(int age, int weight, String breed, String color) {
        super(age, weight, true);
        this.breed = breed;
        this.color = color;
    }

    public void run() {
        System.out.println("Игого, я поскакал(а)");
    }
}
