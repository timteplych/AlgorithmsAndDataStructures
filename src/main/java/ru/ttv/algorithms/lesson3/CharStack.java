package ru.ttv.algorithms.lesson3;


public class CharStack {
    private CharArray stack;
    private int head;

    public CharStack(int size) {
        this.stack = new CharArray(size);
        this.head = -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public void push(char value) {
        //stack[++head] = value;
        stack.append(value);
        head++;
    }

    public char pop() {
        //if (!isEmpty()) return stack[head--];
        char val;
        try {
            val = stack.get(head--);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Stack is Empty");
        }
        stack.remove();
        return val;
    }

    public char peek() {
        //if (!isEmpty()) return stack[head];
        char val;
        try {
            val = stack.get(head);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Stack is Empty");
        }
        return val;
    }
}
