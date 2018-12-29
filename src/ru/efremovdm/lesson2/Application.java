package ru.efremovdm.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Application {

    /**
     * 1. Создать массив большого размера (миллион элементов).
     * 2. Написать методы удаления, добавления, поиска элемента массива.
     * 3. Заполнить массив случайными числами.
     * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
     *
     * @param args
     */
    public static void main(String[] args) {
        addDeleteSearch();
        sorting();
    }

    private static void addDeleteSearch() {
        int count = 10;

        Integer[] elements = new Integer[count];

        for (int i = 0; i < count; i++) {
            elements[i] = i * 2;
        }

        elements = add2Array(elements, 5, 0);
        elements = deleteFromArrayByIndex(elements, 2);
        Integer binary = binaryFildElement(elements, 16);

        System.out.println(Arrays.deepToString(elements));
        System.out.println(binary);
    }

    /**
     * Добавление элемента в массив с помощью создания нового массива.
     *
     * @param ar
     * @param key
     * @param val
     * @return
     */
    private static Integer[] add2Array(Integer[] ar, int key, int val) {

        Integer[] result = new Integer[ar.length + 1];
        for (int i = 0; i <= ar.length; i++) {
            if (i > key) {
                result[i] = ar[i-1];
            }
            else if (i == key) {
                result[i] = val;
            }
            else {
                result[i] = ar[i];
            }
        }

        return result;
    }

    /**
     * Удаление элемента из массива по индексу
     *
     * @param ar
     * @param key
     * @return
     */
    private static Integer[] deleteFromArrayByIndex(Integer[] ar, int key) {

        Integer[] result = new Integer[ar.length - 1];

        for (int i = 0; i < ar.length; i++) {
            if (i != key) {
                result[i < key ? i : i-1] = ar[i];
            }
        }

        return result;
    }

    private static Integer findElement(Integer[] ar, int val) {

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private static Integer binaryFildElement(Integer[] ar, int val) {

        int low = 0;
        int hight = ar.length - 1;
        int mid;
        while (low < hight) {
            mid = (low + hight) / 2;
            if (val == ar[mid]) {
                return mid;
            }
            else if (val < ar[mid]) {
                hight = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;

    }

    private static void sorting() {

        Integer[] array = generateRundomArray(10, 100);

        System.out.println("Original array: " + Arrays.deepToString(array));
        System.out.println("Sort Bubble: " + Arrays.deepToString(sortBubble(array)));
        System.out.println("Select Sort: " + Arrays.deepToString(selectSort(array)));
        System.out.println("Insertions Sort: " + Arrays.deepToString(insertionsSort(array)));
    }

    private static Integer[] generateRundomArray(int elements, int limit) {
        Integer[] array = new Integer[elements];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(limit);
        }

        return array;
    }

    /**
     * Пузырьковая сортировка
     *
     * @param array
     * @return
     */
    private static Integer[] sortBubble(Integer[] array) {

        Integer temp;
        Integer[] result = new Integer[array.length];

        for (int i=0; i < array.length; i++) {  // копируется массив
            result[i] = array[i];
        }

        for (int out = result.length-1; out >= 1; out--) { // внешний цикл с последнего элемента к первому
            for (int in = 0; in < out; in++) { // внутренний прямой обход
                if (result[in] > result[in + 1]) {
                    temp = result[in + 1];
                    result[in + 1] = result[in];
                    result[in] = temp;
                }
            }
        }

        return result;
    }

    /**
     * Сортировка выбором
     *
     * @param array
     * @return
     */
    private static Integer[] selectSort(Integer[] array) {

        Integer[] result = new Integer[array.length];
        int newIndex = 0;
        for (int n = 0; n < array.length; n++) {

            // Ищем место для вставки, просто просматриваем все элементы, но при желании можно использовать бинарный поиск.
            int insertIndex = 0;
            if (newIndex > 0) {
                while (insertIndex < newIndex && result[insertIndex] < array[n]) {
                    insertIndex++;
                }
            }

            // Вставка
            for (int m = newIndex - 1; m >= insertIndex; m--) {
                result[m + 1] = result[m];
            }

            result[insertIndex] = array[n];
            newIndex++;
        }

        return result;
    }

    public static Integer[] insertionsSort(Integer[] array) {

        Integer[] result = new Integer[array.length];

        for (int i=0; i < array.length; i++) {  // копируется массив
            result[i] = array[i];
        }

        for (int i = 1; i < result.length; i++)
        {
            int currVal = result[i];
            int keyPrev = i - 1;
            while ((keyPrev >= 0)&&(currVal < result[keyPrev]))
            {
                result[keyPrev+1] = result[keyPrev];
                result[keyPrev] = currVal;
                keyPrev--;
            }
        }

        return result;
    }
}