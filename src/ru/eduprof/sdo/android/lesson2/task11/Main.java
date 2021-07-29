package ru.eduprof.sdo.android.lesson2.task11;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {4, 2, 5, 4, 5, 8, 3};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= 10) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
