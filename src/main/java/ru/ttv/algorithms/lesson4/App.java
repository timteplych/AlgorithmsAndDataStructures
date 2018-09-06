package ru.ttv.algorithms.lesson4;

import java.util.*;

public class App {
    public static void main(String[] args) {
        DoubleLinkedList<Cat> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insert(new Cat(4,"Kis"));
        doubleLinkedList.insert(new Cat(2,"Pepsi"));
        doubleLinkedList.insert(new Cat(10,"Murka"));
        doubleLinkedList.insert(new Cat(1,"Zhuchka"));
        doubleLinkedList.insert(new Cat(1,"Mashcka"));
        doubleLinkedList.insert(new Cat(1,"Nessi"));
        System.out.println(doubleLinkedList);

        doubleLinkedList.remove();
        System.out.println(doubleLinkedList);


        Iterator<Cat> catIterator = doubleLinkedList.iterator();
        while (catIterator.hasNext()){
            Cat currentCat = catIterator.next();
            if(currentCat.getName().equals("Murka")) {
                catIterator.remove();
            }
        }
    }
}
