package ru.eduprof.sdo.android.lesson5.hotel;

public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        StringBuilder result = new StringBuilder("Свободные комнаты:");
        for (Room room : this.rooms) {
            if (!room.isReserved()) {
                result.append(room.getRoomNumber()).append(" ");
            }
        }
        System.out.println(result);
    }
    // рассмотрим пример для параметров getFreeRooms(true, 0, false, true, 2)
    public void getFreeRooms(boolean wc, int sleepingPlace, boolean conditioner, boolean wifi, int serviceCount){
        StringBuilder result = new StringBuilder("По данному запросу найдены комнаты: ");
        for (Room value : rooms) {
            int mark = 0;
            if (wc && value.isWc()) mark++; // (true && (true||false)) если в комнате есть санузел, то mark = 1
            if (sleepingPlace != 0 && value.getSleepingPlace() == sleepingPlace) mark++; // (false && false) mark = 1
            if (conditioner && value.isConditioner()) mark++; //(false && (true||false)) mark не меняется
            if (wifi && value.isWifi()) mark++; // (true && (true||false)) если в комнате есть wifi, то mark = 2
            if (serviceCount == mark && !value.isReserved()) { // ((true||false) && !(true||false) )
                result.append(value.getRoomNumber()).append(" "); // Пишем в результат номер полученной комнаты
            }
        }
        System.out.println(result); // Печатаем на экран
    }
    public void reserve(int roomNumber){
        String result = "Ошибка: номер не существует";
        for (Room room : this.rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isReserved()) {
                result = ("Номер " + roomNumber + " успешно забронирован");
                room.setReserved(true);
                break;
            } else if (room.getRoomNumber() == roomNumber && room.isReserved()) {
                result = ("Номер " + roomNumber + " занят");
                break;
            }
        }
        System.out.println(result);
    }
    public void getReservedRooms(){
        StringBuilder result = new StringBuilder("Зарезервированные комнаты:");
        for (Room room : this.rooms) {
            if (room.isReserved()) {
                result.append(room.getRoomNumber()).append(" ");
            }
        }
        System.out.println(result);
    }
}
