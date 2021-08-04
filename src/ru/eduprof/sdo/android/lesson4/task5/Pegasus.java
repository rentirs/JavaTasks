package ru.eduprof.sdo.android.lesson4.task5;

public class Pegasus extends Horse {
    public Pegasus(int age, int weight, String breed, String color) {
        super(age, weight, breed, color);
    }

    void fly() {
        System.out.println("Игого, я полетел(а)");
    }
}
