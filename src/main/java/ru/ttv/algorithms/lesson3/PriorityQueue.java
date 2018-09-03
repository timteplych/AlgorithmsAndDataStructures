package ru.ttv.algorithms.lesson3;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int items;

    public PriorityQueue(int size) {
        this.maxSize = size;
        queue = new int[maxSize];
        items = 0;
    }

    public void insert(int item){
        int i;
        if(items == 0){
            queue[items++] = item;
        }else {
            for (i=items-1;i>=0;i--){
                if(item > queue[i]){
                    queue[i+1] = queue[i];
                }else break;
            }
            queue[i+1] = item;
            items++;
        }
    }

    public int remove(){
        return queue[--items];
    }

    public int peek(){
        return queue[items-1];
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == maxSize;
    }
}
