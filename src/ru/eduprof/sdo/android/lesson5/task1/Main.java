package ru.eduprof.sdo.android.lesson5.task1;

/*
 * Дана коллекция имён.
 * 1) удалить все повторяющиеся имена из коллекции
 * 2) вывести коллекцию на экран
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");
        List<String> namesRemoveDuplicates= names.stream().distinct().collect(Collectors.toList());
        System.out.println(namesRemoveDuplicates);
    }
}
