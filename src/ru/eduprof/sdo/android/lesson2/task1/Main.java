package ru.eduprof.sdo.android.lesson2.task1;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Мама", "Мыла", "Раму"};
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (i != k && i != j && k != j) {
                        System.out.println(words[i] + words[j] + words[k]);
                    }
                }
            }
            
        }
    }
}
