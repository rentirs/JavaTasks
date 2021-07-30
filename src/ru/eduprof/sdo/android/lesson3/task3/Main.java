package ru.eduprof.sdo.android.lesson3.task3;

/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        int a = 7;
        int b = 7;
        System.out.println(equal(a, b));
    }

    private static boolean equal(int a, int b) {
        return a == b;
    }
}
