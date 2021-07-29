package ru.eduprof.sdo.android.lesson1.task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        float num = scanner.nextFloat();
        System.out.println(num + " + 15% = " + (num + num * 0.15));
    }
}
