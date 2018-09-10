package ru.ttv.algorithms.lesson5;

public class KnightPath {
    private final int desk[][] = new int[8][8];
    private final static int POSSIBLE_MOVES[][] = {
        {-1, -2}, {-2, -1}, {-2,  1}, { 1, -2},
        {-1,  2}, { 2, -1}, { 1,  2}, { 2,  1} };
    private static final int MAX_MOVES = 64;


    public KnightPath() {
    }

    public int[][] getResultDesk() {
        findPath(0,0,1);
        return desk;
    }

    private boolean findPath(int currentX, int currentY, int moveNumber){
        if(moveNumber > MAX_MOVES){
            return true;
        }
        desk[currentX][currentY] = moveNumber;
        for (int i = 0; i < 8; i++) {
            int nextX = currentX + POSSIBLE_MOVES[i][0];
            int nextY = currentY + POSSIBLE_MOVES[i][1];
            if( movePossible(nextX,nextY) && findPath(nextX, nextY,++moveNumber)){
                return true;
            }
        }
        return false;
    }

    private boolean movePossible(int nextX, int nextY) {
        if(nextX<0 || nextX > 7 || nextY < 0 || nextY > 7){
            return false;
        }
        if(desk[nextX][nextY] == 0){
            return true;
        }
        return false;
    }

}
