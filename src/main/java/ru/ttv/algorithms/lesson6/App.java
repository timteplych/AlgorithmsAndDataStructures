package ru.ttv.algorithms.lesson6;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int amountTrees = 200;
        Random random = new Random();
        Tree[] arrayTree = new Tree[amountTrees];
        for (int i = 0; i < amountTrees; i++) {
            Tree tree = new Tree();
            for (int j = 0; j < 50 ; j++) {
                int catAge = (int)((Math.random() - 0.5d)*2*100);
                tree.insert(new Cat(String.valueOf(catAge),catAge));
            }
            arrayTree[i] = tree;
        }
        int amountBalanced = 0;
        for (int i = 0; i <amountTrees; i++) {
            if (arrayTree[i].isBalanced()) amountBalanced++;
        }
        System.out.println(amountBalanced*100/amountTrees+"%");
    }
}
