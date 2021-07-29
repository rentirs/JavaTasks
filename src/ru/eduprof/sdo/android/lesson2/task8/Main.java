package ru.eduprof.sdo.android.lesson2.task8;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 5};
        int b = 1;
        for (int j : a) {
            b *= j;
        }
        System.out.println(b);
    }
}
