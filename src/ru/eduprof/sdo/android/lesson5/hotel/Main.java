package ru.eduprof.sdo.android.lesson5.hotel;

/*
Улучшить программу работы с отелем. Сделать возможность вводить команду поиска комнаты по параметрам
следующим образом
        getFreeRooms wc wifi sleepingPlace:4
        вместо
        getFreeRooms wc:true wifi:true sleepingPlace:4

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(new Room[]{
                new Room(true, 2, true, true, 11),
                new Room(true, 3, true, true, 12),
                new Room(true, 2, false, false, 13),
                new Room(false, 1, false, false, 14),
                new Room(true, 4, true, true, 21),
                new Room(true, 3, false, false, 22),
                new Room(false, 3, false, false, 23),
                new Room(true, 4, true, false, 24),
                new Room(true, 4, true, true, 31),
                new Room(true, 1, false, false, 32),
                new Room(false, 1, false, false, 33),
                new Room(true, 4, true, false, 34),
        });
        String commands = """
                *----*
                getFreeRooms
                (wc:[true|false])
                (sleepingPlace:[кол-во мест])
                (conditioner:[true|false])
                (wifi:[true|false]))- показать все свободные комнаты
                reserve [номер комнаты] забронировать номер
                getReservedRooms - показать зарезервированные номера
                *----*""";
        System.out.println(commands);
        System.out.println("Введите команду:");
        String command = scanner.nextLine();
        while (!command.equals("exit")) {
            if (command.indexOf("getFreeRooms") == 0) { // Допустим мы ввели getFreeRooms wc:true wifi:true (ниже комментарии для этой команды)
                String[] splitted = command.split(" "); // {"getFreeRooms","wc:true","wifi:true"}
                if (splitted.length == 1)
                    hotel.getFreeRooms(); // Длина массива splitted==1 только тогда, когда мы ввели getFreeRooms и больше ничего
                else {
                    boolean wc = false;
                    int sleepingPlace = 0;
                    boolean conditioner = false;
                    boolean wifi = false;
                    for (int i = 1; i < splitted.length; i++) { // Перебираем заказанные сервисы, для нашего примера {"wc:true","wifi:true"}
                        String[] service = splitted[i].split(":"); // "wc:true" = {"wc","true"}; "wifi:true" = {"wifi", "true"}
                        switch (service[0]) {
                            case "wc" -> wc = true; // wc = true
                            case "sleepingPlace" -> sleepingPlace = Integer.parseInt(service[1]); // sleepingPlace=0
                            case "conditioner" -> conditioner = true; // conditioner = 0
                            case "wifi" -> wifi = true;// (на первой итерации wifi=false) на второй итерации ей будет присвоено значение wifi=true
                        }
                    }
                    // вызываем метод с параметрами getFreeRooms(true, 0, false, true, 2)
                    hotel.getFreeRooms(wc, sleepingPlace, conditioner, wifi, splitted.length - 1);
                }
            } else if (command.indexOf("reserve") == 0) {
                String[] splitted = command.split(" "); // {"reserve", "12"}
                int roomNumber = Integer.parseInt(splitted[1]);
                hotel.reserve(roomNumber);
            } else if (command.equals("getReservedRooms")) {
                hotel.getReservedRooms();
            } else {
                System.out.println("Ошибка: неизвестная команда.\nСписок доступных команд:\n" + commands);
            }
            command = scanner.nextLine();
        }
    }
}
