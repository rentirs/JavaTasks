package ru.eduprof.sdo.android.lesson4.task7;

/*
Реализуй в классе Fox интерфейс Animal.
Учти, что создавать дополнительные классы и удалять методы нельзя!
Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.

Не уверен, что сделал верно. Плохо понял интерфейсы.
*/

import java.awt.*;

public class Main {
    public static void main(String[] args){
    }
}

interface Animal {
    Color getColor();
}

class Fox implements Animal{
    public String getName() {
        return "Fox";
    }

    @Override
    public Color getColor() {
        return Color.red;
    }
}
