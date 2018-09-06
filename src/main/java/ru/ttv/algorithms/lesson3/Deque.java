package ru.ttv.algorithms.lesson3;

public class Deque {
    private int size;
    private int head;
    private int tail;
    private int[] queue;

    public Deque(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void insertLeft(int value){
        tail++;
        if(tail == size){
            tail = 0;
        }
        queue[tail] = value;
    }

    public int removeLeft(){
        int item = queue[tail];
        tail--;
        if(tail<0){
            tail = size - 1;
        }
        return item;
    }

    public void insertRight(int value){
        queue[head] = value;
        head--;
        if(head < 0){
            head = size - 1;
        }
    }

    public int removeRight(){
        head++;
        if(head == size){
            head = 0;
        }
        return queue[head];
    }

    public boolean isEmpty(){
        return head == tail;
    }

}
