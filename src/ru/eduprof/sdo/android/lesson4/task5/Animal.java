package ru.eduprof.sdo.android.lesson4.task5;

abstract class Animal {
    int age;
    int weight;
    boolean vegetarian;

    public Animal(int age, int weight, boolean vegetarian) {
        this.age = age;
        this.weight = weight;
        this.vegetarian = vegetarian;
    }

    void eat() {
        System.out.println("Animal eats");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
