package ru.eduprof.sdo.android.lesson5.task3;

/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList();
        arr1.add(-8);
        arr1.add(7);
        arr1.add(23);
        arr1.add(2);
        arr1.add(192);
        arr1.add(5);
        System.out.println(arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int num : arr1
        ) {
            if (num > 0 && num < 10) {
                arr2.add(num);
            }
        }
        System.out.println(arr2);
    }
}
