package ru.ttv.algorithms.lesson2;

public class App {
    public static void main(String[] args) {
        Array arr = new Array(7);
        arr.append(1);
        arr.append(2);
        arr.append(9);
        arr.append(6);
        arr.append(5);
        arr.append(5);
        arr.quickSort();
        System.out.println(arr);

        arr.delete(3);
        System.out.println(arr);

        arr.deleteAll(5);
        System.out.println(arr);

        arr.deleteAll();
        System.out.println(arr);
    }
}
