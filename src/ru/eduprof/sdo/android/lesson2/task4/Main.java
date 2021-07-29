package ru.eduprof.sdo.android.lesson2.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада: ");
        float deposit = scanner.nextFloat();
        System.out.println("Введите ежегодный процент: ");
        float percent = scanner.nextFloat();
        float plus = 0;
        for (int i = 1; i <= 5; i++) {
            deposit = deposit + deposit * percent /100;
            System.out.println("Сумма вклада после " + i + "го года составит: " + deposit);

        }
    }
}
