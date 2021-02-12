package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Задание 2.1
        //На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих
        // примитивных или ссылочных типов данных.
        //Выполните обращение к массиву и базовые операции класса Arrays.
        //Оценить выполненные методы с помощью базового класса System.nanoTime().
        int numberA = 3;
        int numberB = 2;
        int numberС = 4;
        int numberD = 1;
        int numberE = 5;
        int numberF = 4;
        int numberG = 6;

        int[] arrayOfNumbers = {numberA, numberB, numberС, numberD, numberE, numberF, numberG};
        System.out.println(arrayOfNumbers.length);
        System.out.println(arrayOfNumbers.toString());
        System.out.println(Arrays.toString(arrayOfNumbers));
        int [] copyArr;
        copyArr = Arrays.copyOf(arrayOfNumbers, arrayOfNumbers.length);
        long a = System.nanoTime();
        Arrays.sort(copyArr);
        System.out.println(Arrays.toString(copyArr));
        System.out.println(System.nanoTime() - a);


        //Задание 2.2
        //На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        //Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
        // при необходимости расширьте уже существующий массив данных.

        linearSearch(1, arrayOfNumbers);
        binarySearch(4, arrayOfNumbers);

        //Задание 2.3
        //
        //Создайте массив размером 400 элементов.
        //Выполните сортировку с помощью метода sort().
        //Оцените сортировку с помощью базового класса System.nanoTime().
         final int SIZE = 400;
         int[] newArr = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            newArr[i] = rand.nextInt(15);
        }
        int[] copyNewArr = Arrays.copyOf(newArr, newArr.length);
        int[] copyNewArrForSelectSort = Arrays.copyOf(newArr, newArr.length);
        int[] copyNewArrForPastSort = Arrays.copyOf(newArr, newArr.length);
        System.out.println(Arrays.toString(newArr));
        long b = System.nanoTime();
        Arrays.sort(newArr);
        System.out.println("Время затраченное на быструю сортировку " + (System.nanoTime() - b));
        long timeSpendForQuickSort = System.nanoTime() - b;


        //Задание 2.4
        //На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        //Оцените сортировку с помощью базового класса System.nanoTime().
        //Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.

         long timeSpendForBubbleSort = bubbleSort(copyNewArr);
        System.out.println("Сравнение во сколько раз быстрая сортировка превосходит пузырьковую "
                + timeSpendForBubbleSort/timeSpendForQuickSort);


        //Задание 2.5
        //На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        //Оцените сортировку с помощью базового класса System.nanoTime().
        //Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.

        long timeSpendForSelectionSort = selectionSort(copyNewArrForSelectSort);

        System.out.println("Сравнение во сколько раз быстрая сортировка превосходит пузырьковую и выборкой "
                + timeSpendForBubbleSort/timeSpendForQuickSort + " и " + timeSpendForSelectionSort/timeSpendForQuickSort);


        //Задание 2.6
        //На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        //Оцените сортировку с помощью базового класса System.nanoTime().
        //Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

        long timeSpendForPastSort = pastSort(copyNewArrForPastSort);

        System.out.println("Сравнение во сколько раз быстрая сортировка превосходит пузырьковую и выборкой и вставкой "
                + timeSpendForBubbleSort/timeSpendForQuickSort + " и " + timeSpendForSelectionSort/timeSpendForQuickSort +
                " и " + timeSpendForPastSort/timeSpendForQuickSort);

    }

    private static void linearSearch(int i, int[] arrayOfNumbers) {
        long a = System.nanoTime();
        for (int j = 0; j < arrayOfNumbers.length; j++) {
            if (arrayOfNumbers[j] == i){
                System.out.println(Arrays.toString(arrayOfNumbers));
                System.out.println("Успех эллемент в индексе " + j);
                System.out.println(System.nanoTime() - a);
                System.out.println("Время затраченное на линейный поиск " + (System.nanoTime() - a));
                return;
            }

        }

    }

    private static void binarySearch(int i, int[] arrayOfNumbers) {
        long a = System.nanoTime();
        Arrays.sort(arrayOfNumbers);
        int middle = (arrayOfNumbers.length - 1)/2;
        int[] copyArr;
        boolean notFind = true;
        while(notFind){
            if(arrayOfNumbers[middle] == i || arrayOfNumbers[middle - 1] == i || arrayOfNumbers[middle + 1] == i){
                System.out.println("Успех эллемент найден");
                notFind = false;
            }
            else if(arrayOfNumbers[middle] > i){
                middle = middle - middle/2;
            }
            else if(arrayOfNumbers[middle] < i){
                middle = middle + middle/2;
            }
        }
        System.out.println("Время затраченное на двойчный поиск " + (System.nanoTime() - a));
    }

    private static long bubbleSort(int[] copyNewArr) {
        long a = System.nanoTime();
        int buffer;
        for (int i = 0; i < copyNewArr.length - 1; i++) {
            for (int j = copyNewArr.length - 1;  j > i; j--) {
                if(copyNewArr[j] < copyNewArr[j - 1]){
                    buffer = copyNewArr[j];
                    copyNewArr[j] = copyNewArr[j - 1];
                    copyNewArr[j - 1] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(copyNewArr));
        System.out.println("Время затраченное на сортировку пузырьком " + (System.nanoTime() - a));
        long b = System.nanoTime() - a;
        return b;
    }

    private static long selectionSort(int[] copyNewArrForSelectSort) {
        long a = System.nanoTime();
        int buff;
        for (int i = 0; i < copyNewArrForSelectSort.length - 1; i++) {
            for (int j = i; j < copyNewArrForSelectSort.length; j++) {
                if(copyNewArrForSelectSort[i] > copyNewArrForSelectSort[j]){
                    buff = copyNewArrForSelectSort[j];
                    copyNewArrForSelectSort[j] = copyNewArrForSelectSort[i];
                    copyNewArrForSelectSort[i] = buff;
                }
            }
        }
        System.out.println(Arrays.toString(copyNewArrForSelectSort));
        System.out.println("Время затраченное на сортировку выборкой " + (System.nanoTime() - a));
        long b = System.nanoTime() - a;
        return b;
    }

    private static long pastSort(int[] copyNewArrForPastSort) {
        long a = System.nanoTime();
        int buff;
        for (int i = 1; i < copyNewArrForPastSort.length; i++) {
            if(copyNewArrForPastSort[i] < copyNewArrForPastSort[i - 1]){
                int j = i;
                while (j > 0){
                    if (copyNewArrForPastSort[j] < copyNewArrForPastSort[j - 1]){
                        buff = copyNewArrForPastSort[j];
                        copyNewArrForPastSort[j] = copyNewArrForPastSort[j - 1];
                        copyNewArrForPastSort[j - 1] = buff;
                    }
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(copyNewArrForPastSort));
        System.out.println("Время затраченное на сортировку вcтавками " + (System.nanoTime() - a));
        long b = System.nanoTime() - a;
        return b;

    }
}
