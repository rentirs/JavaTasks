package ru.eduprof.sdo.android.lesson2.task10;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {5, 3, 6, 3, 7, 4, 4};
        String answer = "нет";
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                answer = "да";
            }
        }
        System.out.println(answer);
    }
}
