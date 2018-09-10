package ru.ttv.algorithms.lesson5;

import ru.ttv.algorithms.lesson3.Stack;

public class HanoiTowers {
    private int disksAmount;

    public HanoiTowers(int disksAmount) {
        this.disksAmount = disksAmount;
    }

    public void start(){
        Stack tower1 = new Stack(disksAmount);
        Stack tower2 = new Stack(disksAmount);
        Stack tower3 = new Stack(disksAmount);

        for (int i = 1; i <=disksAmount ; i++) {
            tower1.push(i);
        }
        step(disksAmount, tower1,tower3,tower2);
    }

    private void step(int n, Stack tower1, Stack tower3, Stack tower2){
        if(n > 0){
            step(n-1,tower1,tower2,tower3);
            tower3.push(tower1.pop());
            step(n-1,tower2,tower3,tower1);
        }
    }
}
