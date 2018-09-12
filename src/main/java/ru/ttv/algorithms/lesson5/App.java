package ru.ttv.algorithms.lesson5;

import ru.ttv.algorithms.lesson2.Array;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //#task#1
        HanoiTowers hanoiTowers = new HanoiTowers(5);
        hanoiTowers.start();

        //#task2
        KnightPath knightPath = new KnightPath();
        int[][] result = knightPath.getResultDesk();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(result[i][j]+", ");
            }
            System.out.println("");
        }
    }




}
