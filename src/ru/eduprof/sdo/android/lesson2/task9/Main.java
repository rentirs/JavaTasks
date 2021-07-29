package ru.eduprof.sdo.android.lesson2.task9;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        String answer = "нет";
        for (int j : a) {
            if (j == 5) {
                answer = "да";
                break;
            }
        }
        System.out.println(answer);
    }
}
