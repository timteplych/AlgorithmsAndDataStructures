package ru.ttv.algorithms.lesson3;

public class CharArray {
    private char[] arr;
    private int size;
    private boolean isSorted;

    private CharArray() {
        isSorted = false;
    }

    public CharArray(int size) {
        this();
        this.size = 0;
        arr = new char[size];
    }

    public CharArray(char... args) { // int[] args = new int[args.length];
        this();
        size = args.length;
        arr = args;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public int length() {
        return size;
    }

    public char get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        return arr[index];
    }

    public void set(int index, char value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        arr[index] = value;
    }

    public void append(char value) {
        if (size >= arr.length - 1) {
            char[] temp = arr;
            arr = new char[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
    }

    public boolean remove(){
        if (size == 0)
            return false;
        size--;
        return true;
    }

    // homework
    public boolean delete(int index) {
        if(index>=size) throw new IndexOutOfBoundsException("Out of bounds!");
        char[] temp = arr;
        arr = new char[size--];
        System.arraycopy(temp,0,arr,0,index);
        System.arraycopy(temp,index+1,arr,index,arr.length-index-1);
        return true;
    }

    public boolean deleteAll(int value) {
        boolean finish = false;
        int deletedElements = 0;
        sortBubble();
        while(!finish){
            int elemIndex = find(value);
            if(elemIndex == -1){
                finish = true;
            }else {
                delete(elemIndex);
                deletedElements++;
            }
        }
        if(deletedElements == 0) return false;
        return true;
    }

    public boolean deleteAll() {
        size = 0;
        return true;
    }

    public boolean isInArray(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
    // k << n == k * 2 ^ n
// k >> n == k / 2 ^ n
    public int find(int value) {
        if (!isSorted)
            throw new RuntimeException("Trying to search in unsorted array");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // 8 = 00001000 >> 2 = 00000010 = 2
            if (value == arr[m]) {
                return m;
            } else {
                if (value < arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    private void swap(int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);

            }
        }
        isSorted = true;
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
