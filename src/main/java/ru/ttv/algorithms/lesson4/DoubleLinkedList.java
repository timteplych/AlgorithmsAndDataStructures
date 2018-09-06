package ru.ttv.algorithms.lesson4;

import java.util.*;
import java.util.function.Consumer;

public class DoubleLinkedList<T>{
    private class Node<T> {
        T c;
        Node<T> next;
        Node<T> prev;
        public Node(T c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return c.toString();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<T> node = (Node) o;
            return Objects.equals(c, node.c);
        }
    }

    private class Itr implements Iterator<T> {
        Node<T> cursor = head;       // index of next element to return

        public boolean hasNext() {
            return cursor != null;
        }

        public T next() {
            T temp = cursor.c;
            cursor = cursor.next;
            return temp;
        }

        public void remove() {
            if (isEmpty())
                throw  new IndexOutOfBoundsException();
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = cursor.next;
        }
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            while (hasNext())
                action.accept(next());
        }
    }

    private Node<T> head;

    public DoubleLinkedList() {
        this.head = null;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T c) {
        Node<T> n = new Node<>(c);
        n.next = head; // if (head == null) n.next = null;
        if(head == null){
            n.prev = null;
        }else
            n.prev = head.prev;
        head = n;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T temp = head.c;
        head.next.prev = head.prev;
        if(head.prev != null){
            head.prev.next = head.next;
        }
        head = head.next;
        return temp;
    }

    public boolean contains(T c) {
        Node<T> n = new Node<>(c);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public T delete(String name) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!(((Cat)current.c).getName()).equals(name)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;

        return current.c;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }


}
