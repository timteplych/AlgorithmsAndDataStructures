package ru.ttv.algorithms.lesson2;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        arr = new int[size];
    }

    public Array(int... args) { // int[] args = new int[args.length];
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

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        return arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        arr[index] = value;
    }

    public void append(int value) {
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
    }

    public boolean remove() {
        if (size == 0)
            return false;
        size--;
        return true;
    }

    // homework
    public boolean delete(int index) {
        if(index>=size) throw new IndexOutOfBoundsException("Out of bounds!");
        int[] temp = arr;
        arr = new int[size--];
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
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Внешний цикл выполняется n-1 раз, а внутренний выполняется в среднем n/2 раз
     * итого, количество операций (n^2 - n)/2, при достаточно высоком n будет приближаться
     * к n^2, что соответствует эффективности O(n^2)
     */
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);

            }
        }
        isSorted = true;
    }

    /**
     * quicksort - улучшенный метод пузырьковой сортировки
     * эффективность O(n log n)
     *
     */
    public void quickSort() {
        doQuickSort(0, size-1);
    }
    private void doQuickSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doQuickSort(start, cur);
        doQuickSort(cur+1, end);
    }

    /**
     * Внешний цикл выполняется n-1 раз, а внутренний выполняется в среднем n/2 раз
     * итого, количество операций (n^2 - n)/2, при достаточно высоком n будет приближаться
     * к n^2, что соответствует эффективности O(n^2)
     */
    public void sortSelect() {
        int f;
        for (int i = 0; i < size; i++) {
            f = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[f])
                    f = j;
            }
            swap(i, f);
        }
        isSorted = true;
    }

    /**
     *  Количество сравнений в сортировке вставками зависит от изначальной упорядоченности списка.
     *  Если список уже отсортирован, количество операций равно n-1 O(n), иначе его эффективность является величиной порядка n^2 O(n^2)
     */
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
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
