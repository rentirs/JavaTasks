package ru.eduprof.sdo.android.lesson2.task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        if (a % b == 0) {
            System.out.println("Делится");
        } else {
            System.out.println("Делится с остатком " + a % b);
        }
    }
}
