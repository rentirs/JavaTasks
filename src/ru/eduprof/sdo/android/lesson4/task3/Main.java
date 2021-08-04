package ru.eduprof.sdo.android.lesson4.task3;

/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true, либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и то же значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
    Cat cat1 = new Cat();
    cat1.age = 5;
    cat1.weight = 2;
    cat1.strength = 50;
    Cat cat2 = new Cat();
    cat2.age = 10;
    cat2.weight = 2;
    cat2.strength = 30;

        System.out.println(cat1.fight(cat2));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int score = 0;
        if (this.age > anotherCat.age) {
            ++score;
        } else {
            --score;
        }
        if (this.weight > anotherCat.weight) {
            ++score;
        } else {
            --score;
        }
        if (this.strength > anotherCat.strength) {
            ++score;
        } else {
            --score;
        }
        return score > 0;
    }
}
