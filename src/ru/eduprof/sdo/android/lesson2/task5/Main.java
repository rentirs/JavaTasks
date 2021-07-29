package ru.eduprof.sdo.android.lesson2.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int a = scanner.nextInt();
        System.out.println(a == 10 ? "Верно" : "Неверно");
    }
}
