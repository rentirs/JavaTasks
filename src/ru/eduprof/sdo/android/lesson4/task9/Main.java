package ru.eduprof.sdo.android.lesson4.task9;

/*
Задача, доработать код с вебинара.

Составить генеалогическое древо. У вас должно быть 2 бабушки, 2 дедушки, мама, папа, ребёнок.
Для всех персонажей должен корректно работать метод info()
На экран должно попасть максимум информации.
Т.е. для ребенка нужно вывести инфо о родителях, а так же о бабушках и дедушках.
Задачу сдать как task_4.9
*/

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Григорий", "Петров", 68, null, null);
        Person p5 = new Person("Виктория", "Петрова", 65, null, null);
        Person p6 = new Person("Александр", "Иванов", 72, null, null);
        Person p7 = new Person("Кьяра", "Бернардо", 67, null, null);
        Person p2 = new Person("Ольга", "Иванова", 45, p5, p1);
        Person p3 = new Person("Алексей", "Иванов", 45, p7, p6);
        Person p4 = new Person("Николай", "Иванов", 20, p2, p3);
        p4.info();
    }
}

class Person { // Описание того, как должен выглядеть человек
    String name;
    String lastname;
    int age;
    Person mother;
    Person father;

    Person(String name, String lastname, int age, Person mother, Person father) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }

    void info() {
        String info = "Привет меня зовут " + this.name + " " + this.lastname + "\n" +
                "Мне " + this.age + " лет \n";

        if (this.mother != null) { // Проверка существования матери
            info += "Мою маму зовут " + this.mother.name + "\n";
            if (this.mother.father != null) { // Проверка существования отца матери (дедушки по маминой линии)
                info += "Дедушку по маминой линии зовут " + this.mother.father.name + "\n";
            }
            if (this.mother.mother != null) {
                info += "Бабушку по маминой линии зовут " + this.mother.mother.name + "\n";
            }
        }
        if (this.father != null) {
            info += "Моего папу зовут " + this.father.name + "\n";
            if (this.father.father != null) {
                info += "Дедушку по папиной линии зовут " + this.father.father.name + "\n";
            }
            if (this.father.mother != null) {
                info += "Бабушку по папиной линии зовут " + this.father.mother.name + "\n";
            }
        }
        System.out.println(info);
    }

    void sayHi(String name) {
        System.out.println("Привет " + name);
    }
}
