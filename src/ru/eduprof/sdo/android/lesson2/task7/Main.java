package ru.eduprof.sdo.android.lesson2.task7;

public class Main {
    public static void main(String[] args) {
        int a = 31;
        Boolean b = false;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                b = true;
                break;
            }
        }
        System.out.println(b);
    }
}
