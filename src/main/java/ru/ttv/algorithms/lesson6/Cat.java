package ru.ttv.algorithms.lesson6;

public class Cat {
    private static int uid = 0;
    String name;
    int age;
    int id;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        id = uid++;
    }
}
