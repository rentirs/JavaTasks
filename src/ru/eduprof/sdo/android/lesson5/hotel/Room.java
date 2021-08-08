package ru.eduprof.sdo.android.lesson5.hotel;

public class Room {
    private final boolean wc;
    private final int sleepingPlace;
    private final boolean conditioner;
    private final boolean wifi;
    private final int roomNumber;
    private boolean reserved;
    Room(boolean wc, int sleepingPlace, boolean conditioner, boolean wifi, int roomNumber){
        this.conditioner = conditioner;
        this.sleepingPlace = sleepingPlace;
        this.wc = wc;
        this.wifi = wifi;
        this.roomNumber = roomNumber;
        this.reserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isWc() {
        return wc;
    }

    public int getSleepingPlace() {
        return sleepingPlace;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public boolean isWifi() {
        return wifi;
    }

}
