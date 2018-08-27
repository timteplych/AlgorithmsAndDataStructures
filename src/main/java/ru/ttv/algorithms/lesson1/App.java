package ru.ttv.algorithms.lesson1;

public class App {
    public static void main(String[] args) {
        System.out.println(pow(2,4));
        int[] mas = new int[]{10,6,24,46,10,8};
        System.out.println(findMin(mas));
        System.out.println(avg(mas));
    }

    /**
     *
     * При возведении в степень n число операций будет равно n-1, эффективность будет O(n-1)
     * при высоком n еденицей можно принебреч и эффективность можно записать как O(n)
     */
    private static float pow(float base, int power){
        float result = base;
        for (int i = 1; i <power ; i++) {
            result *= base;
        }
        return result;
    }

    /**
     *
     * При поиске минимального элемента в массиве размером n число операций будет равно n-1,
     * эффективнотсь будет равна O(n-1), при достаточно большом числе элементов в массиве
     * единицей можно принебреч и эффективность можно записать как O(n)
     */
    private static int findMin(int[] array){
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
            }
        }
        return min;
    }

    /**
     *
     * При вычислении среднего значения массива длиной n число операций будет равно n+1,
     * эффективность можно записать как O(n+1), при достаточно высоком n единицей можно
     * принебреч и записать эффективность как O(n)
     */
    private static float avg(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }
}
