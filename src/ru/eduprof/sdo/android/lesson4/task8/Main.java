package ru.eduprof.sdo.android.lesson4.task8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питание(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   +Освободить комнату.
 *   +Вывести свойства комнаты.
 *   +Показать комнаты с WiFi
 *   +Показать комнаты с WC
 *   +Показать комнаты с Eat
 *   +Показать комнаты по кол-ву спальных мест.
 *   Отобразить список команд.
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1, false, false, true, (byte) 11),
                new Room((byte) 2, true, true, false, (byte) 12),
                new Room((byte) 1, false, true, true, (byte) 13),
                new Room((byte) 3, true, false, false, (byte) 21),
                new Room((byte) 2, false, false, false, (byte) 22),
                new Room((byte) 1, true, true, true, (byte) 23),
                new Room((byte) 3, false, true, false, (byte) 31),
                new Room((byte) 3, true, true, false, (byte) 32),
                new Room((byte) 1, false, false, true, (byte) 33),
        };
        HashMap<String, String> commands = new HashMap<>();
        commands.put("getFreeRooms", "Показать свободные комнаты");
        commands.put("reserveRoom", "Забронировать комнату");
        commands.put("unReserveRoom", "Освободить комнату");
        commands.put("information", "Вывести свойства комнаты");
        commands.put("getWifi", "Показать комнаты с WiFi");
        commands.put("getWc", "Показать комнаты с WC");
        commands.put("getEat", "Показать комнаты с питанием");
        commands.put("getBeds", "Показать комнаты по кол-ву спальных мест");
        commands.put("exit", "Выйти из программы");

        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        label:
        while (true) {
            System.out.println("Введите команду\nhelp - отобразить список доступных команд");
            command = scanner.nextLine();
            switch (command) {
                case "getFreeRooms":
                    hotel.getFreeRooms();
                    break;
                case "reserveRoom":
                    hotel.reserveRoom(hotel.enteringRoom());
                    break;
                case "unReserveRoom":
                    hotel.unReserveRoom(hotel.enteringRoom());
                    break;
                case "information":
                    hotel.information(hotel.enteringRoom());
                    break;
                case "getWifi":
                    hotel.getWifi();
                    break;
                case "getWc":
                    hotel.getWc();
                    break;
                case "getEat":
                    hotel.getEat();
                    break;
                case "getBeds":
                    hotel.getBeds();
                    break;
                case "help":
                    commands.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(b -> System.out.println(b.getKey() + " - " + b.getValue()));
                    break;
                case "exit":
                    break label;
                default:
                    System.out.println("Ошибка. Проверьте написание команды");
            }
        }
    }
}
