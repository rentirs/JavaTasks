package ru.eduprof.sdo.android.lesson4.task8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms() {
        String freeRoomsList = "";
        for (Room room : rooms) {
            if (room.isFree()) freeRoomsList += room.getRoomNumber() + ", ";
        }
        System.out.println("Номера свободных комнат " + freeRoomsList);
    }

    public void reserveRoom(byte roomNumber) {
        String info = "";
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isFree()) {
                room.setFree(false);
                info = ("Комната номер " + roomNumber + " успешно забронированна");
                break;
            } else if (room.getRoomNumber() == roomNumber && !room.isFree()) {
                info = "Комната " + roomNumber + " занята";
                break;
            }
        }
        System.out.println(info);
    }

    public void unReserveRoom(byte roomNumber) {
        String info = "";
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isFree()) {
                room.setFree(true);
                info = ("Комната номер " + roomNumber + " успешно освобождена");
                break;
            } else if (room.getRoomNumber() == roomNumber && room.isFree()) {
                info = "Комната " + roomNumber + " уже свободна";
                break;
            }
        }
        System.out.println(info);
    }

    public void information(byte roomNumber) {
        String info = "";
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                info = ("Информация по комнате номер " + roomNumber + ": количество мест - " + room.getQuantity() +
                        ", Санузел - " + (room.isWc() ? "Да" : "Нет") + ", Питание - " + (room.isEat() ? "Есть" :
                        "Нет") + ", Wi-Fi - " + (room.isWifi() ? "Есть" : "Нет") + (room.isFree() ? ", номер свободен."
                        : ", номер занят."));
                break;
            }
        }
        System.out.println(info);
    }

    public byte enteringRoom() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        byte roomNumber = 0;
        while (!check) {
            System.out.print("Введите номер комнаты: ");
            roomNumber = scanner.nextByte();
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Нет такого номера комнаты");
            }
        }
        return roomNumber;
    }

    public void getWifi() {
        System.out.println("Номера комнат c WiFi:");
        for (Room room : rooms) {
            if (room.isWifi()) System.out.println(room.getRoomNumber() + (room.isFree() ? " - номер свободен."
                    : " - номер занят."));
        }
    }

    public void getWc() {
        System.out.println("Номера комнат c санузлом:");
        for (Room room : rooms) {
            if (room.isWc()) System.out.println(room.getRoomNumber() + (room.isFree() ? " - номер свободен."
                    : " - номер занят."));
        }
    }

    public void getEat() {
        System.out.println("Номера комнат c питанием:");
        for (Room room : rooms) {
            if (room.isEat()) System.out.println(room.getRoomNumber() + (room.isFree() ? " - номер свободен."
                    : " - номер занят."));
        }
    }

    public void getBeds() {
        System.out.println("Комнаты по количеству спальных мест:");
        HashMap<Byte, Byte> map = new HashMap<>();
        for (Room room : rooms
        ) {
            map.put(room.getRoomNumber(), room.getQuantity());
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(byteByteEntry -> System.out.println("Номер " + byteByteEntry.getKey() + " вмещает " + byteByteEntry.getValue() + (byteByteEntry.getValue() == 1 ? " гостя" : " гостей")));
    }
}
