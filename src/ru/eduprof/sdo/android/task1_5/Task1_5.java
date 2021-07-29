package ru.eduprof.sdo.android.task1_5;

import java.util.Scanner;

public class Task1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение температуры в цельсиях: ");
        float tempC = scanner.nextFloat();
        System.out.println(tempC + "C = " + ((9.0 / 5.0) * tempC + 32) + "F");
    }
}
