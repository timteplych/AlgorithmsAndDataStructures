package ru.ttv.algorithms.lesson3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Task#1
        String str = "(2+3)*((6-2)*4))";
        char openSymbol = '(';
        char closeSymbol = ')';
        checkBracketsEnclosed(str,openSymbol,closeSymbol);

        //Task#2
        reverseInputString();

        //Task#3
        Deque deque = new Deque(5);
        deque.insertLeft(2);
        deque.insertLeft(5);
        deque.insertRight(6);
        deque.insertRight(7);
        deque.insertRight(1);

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());



        //Task#4
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(8);
        priorityQueue.insert(7);
        priorityQueue.insert(9);
        priorityQueue.insert(3);
        priorityQueue.insert(8);
        int item = priorityQueue.remove();
        System.out.println(item);

    }

    private static void reverseInputString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        CharStack stack = new CharStack(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        scanner.close();
    }

    public static void checkBracketsEnclosed(String str, char openSymbol, char closeSymbol){
        char[] chars = str.toCharArray();
        Stack stack = new Stack(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == openSymbol){
                stack.push(1);
            }else if(chars[i] == closeSymbol){
                if(stack.isEmpty()) {
                    System.out.println("Лишний закрывающий символ!");
                    break;
                }else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) System.out.println("Лишний открывающий символ!");
    }
}
