package ru.eduprof.sdo.android.lesson2.task12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int sum = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 10 чисел для массива:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                sum++;
                if (max < sum){
                    max = sum;
                }
            } else sum = 0;
        }
        System.out.print("В массиве: ");
        for (int a : array
             ) {
            System.out.print(a + "\t");
        }
        System.out.println();
        System.out.println("Самая длинная последовательность из" + (max + 1) + " чисел");
    }
}
