package ru.eduprof.sdo.android.task1_7;

import java.util.Scanner;

public class Task1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размеры бассейна:\nДлина: ");
        int a = scanner.nextInt();
        System.out.print("Ширина: ");
        int b = scanner.nextInt();
        System.out.print("Глубина: ");
        int c = scanner.nextInt();
        int volume = a * b * c * 1000;
        System.out.println("Количество воды необходимое для заполнения бассейна: " + volume + " литров.");
    }
}
