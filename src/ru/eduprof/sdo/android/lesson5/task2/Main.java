package ru.eduprof.sdo.android.lesson5.task2;

/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.HashMap;
import java.util.Scanner;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String city, family;
        while (true) {
            System.out.println("Введите город:");
            city = scanner.nextLine();
            if (map.containsKey(city)) {
                System.out.println("В городе " + city + " живут " + map.get(city));
                continue;
            }
            System.out.println("Введите фамилию:");
            family = scanner.nextLine();
            if (city.equals("") || family.equals("")) break;
            map.put(city, family);
        }
    }
}
