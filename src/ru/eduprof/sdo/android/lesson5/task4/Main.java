package ru.eduprof.sdo.android.lesson5.task4;

/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            SortedSet<Integer> sortedSet = new TreeSet();
            System.out.println("Введите путь к файлу:");
            String path = scanner.nextLine(); //"./test/fileFor5_4.txt"
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine();
            while (line != null) {
                if (Integer.parseInt(line)%2 == 0) sortedSet.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }
            sortedSet.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
