package ru.eduprof.sdo.android.lesson3.task5;

/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.

Про рекурсию узнал в первый раз. Поэтому сделал, как понял)) Наверное, не совсем рационально.
*/


public class Main {
    public static void main(String[] args) {
        int[] num = {4, 2, 6, 2, 65};
        printArray(num, num.length);
    }

    private static void printArray(int[] num, int l) {
        if (l > 0) {
            System.out.println(num[num.length - l]);
            l--;
            printArray(num, l);
        }
    }
}