package ru.eduprof.sdo.android.lesson3.task4;

/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.
*/


public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        System.out.println(SumMoreTen(a, b));
    }

    private static boolean SumMoreTen(int a, int b) {
        return a + b > 10;
    }
}
