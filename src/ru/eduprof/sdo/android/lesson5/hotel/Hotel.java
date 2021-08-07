package ru.eduprof.sdo.android.lesson5.hotel;

public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String result = "Свободные комнаты:";
        for (int i = 0; i < this.rooms.length; i++) {
            if(!this.rooms[i].isReserved()){
                result += (this.rooms[i].getRoomNumber()+" ");
            }
        }
        System.out.println(result);
    }
    // рассмотрим пример для параметраметров getFreeRooms(true, 0, false, true, 2)
    public void getFreeRooms(boolean wc, int sleepinPlace, boolean conditioner, boolean wifi, int serviceCount){
        String result = "По данному запросу найдены комнаты: ";
        for (int i = 0; i < rooms.length; i++) {
            int mark = 0;
            Room room = rooms[i];
            if(wc && room.isWc()) mark++; // (true && (true||false)) если в комнате есть сан.узел, то mark = 1
            if(sleepinPlace!=0 && room.getSleepingPlace() == sleepinPlace) mark++; // (false && false) mark = 1
            if(conditioner && room.isConditioner()) mark++; //(false && (true||false)) mark не меняется
            if(wifi && room.isWifi()) mark++; // (true && (true||false)) если в комнате есть wifi, то mark = 2
            if(serviceCount == mark && !room.isReserved()){ // ((true||false) && !(true||false) )
                result += room.getRoomNumber()+" "; // Пишем в результат номер полученной комнаты
            }
        }
        System.out.println(result); // Печатаем на экран
    }
    public void reserve(int roomNumber){
        String result = "Ошибка: номер не существует";
        for (int i = 0; i < this.rooms.length; i++) {
            if(this.rooms[i].getRoomNumber() == roomNumber && !this.rooms[i].isReserved()){
                result = ("Номер "+roomNumber+" успешно забронирован");
                rooms[i].setReserved(true);
                break;
            }else if (this.rooms[i].getRoomNumber() == roomNumber && this.rooms[i].isReserved()){
                result = ("Номер "+roomNumber+" занят");
                break;
            }
        }
        System.out.println(result);
    }
    public void getReservedRooms(){
        String result = "Зарезервированные комнаты:";
        for (int i = 0; i < this.rooms.length; i++) {
            if(this.rooms[i].isReserved()){
                result += (this.rooms[i].getRoomNumber()+" ");
            }
        }
        System.out.println(result);
    }
}
