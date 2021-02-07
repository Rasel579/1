package lesson5;

import java.util.Arrays;

public class Main {
    //Задание 5.1
    //Приведите пример использования рекурсии.

    //Использование в алгоритмах сортировки и поиска

    //Задание 5.2
    //Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
    public static void main(String[] args) {
       // infiniteRecursion(100);
        stateRecursion(100);

        //Задание 5.3
        //Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        System.out.println(methodAdd(2,5));
        System.out.println( factorial(5));

        //Задание 5.4
        //Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        //Оцените два алгоритма с помощью базового метода System.nanoTime().
        //Задание 5.5
        //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        //Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime()
        // и сравните с обычным двоичным поиском.
        int[] arr = {6,3,7,8,9};
        long a = System.nanoTime();
        System.out.println(cycledBinaryFind(arr, 9));
        System.out.println(System.nanoTime() -a);
        a = System.nanoTime();
        System.out.println(recursionBinaryFind(arr, 3));
        System.out.println( System.nanoTime() - a);

        //Задание 5.6
        //На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        //Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime()
        // и сравните с сортировкой методом sort().

        int [] newArr = {6,3,7,65,9,34,54,23,765,235,65,34,126,76,32};
        int[] copyArr = Arrays.copyOf(newArr, newArr.length);
        a = System.nanoTime();
        mergeSort(newArr);
        System.out.println(System.nanoTime() - a);

        a = System.nanoTime();
        Arrays.sort(copyArr);
        System.out.println(System.nanoTime() - a);

        

    }

    private static int infiniteRecursion(int i) {
        System.out.println(i);
        return i = infiniteRecursion(i - 1);
    }

    private static int stateRecursion(int i) {
        System.out.println(i);
        if (i == 1){
            return i;
        }
      return  i = stateRecursion(i -1);
    }

    private static int methodAdd(int i, int b) {
        return methodInner(i, b);
    }

    public static int methodInner(int i, int b){
        return i + b;
    }

    private static int factorial(int i) {
        if (i == 1){
            return i;
        }
        return i * factorial(i - 1);
    }

    private static int cycledBinaryFind(int[] arr, int i) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int mid = arr.length/2;
        while (arr[mid] != i){
            if (arr[mid] < i){
                arr = Arrays.copyOfRange(arr, mid, arr.length);
            } else if (arr[mid] > i) {
                arr = Arrays.copyOfRange(arr, 0, mid);
            }
            mid = arr.length/2;
        }
        return arr[mid];
    }

    private static int recursionBinaryFind(int[] arr, int i) {
        int mid = arr.length/2;
        if(arr[mid] == i){
            return arr[mid];
        }
        if (arr[mid] < i) {
            return  recursionBinaryFind(Arrays.copyOfRange(arr, mid, arr.length), i );
        }
        else {
            return recursionBinaryFind(Arrays.copyOfRange(arr, 0, mid), i );
        }
    }


    private static int[] mergeSort(int[] arr) {
        if(arr.length < 2){
            return arr;
        }
        int mid = arr.length/2;
        int[] leftPart = Arrays.copyOfRange(arr, 0, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(leftPart), mergeSort(rightPart));
        
    }

    private static int[] merge(int[] mergeSort, int[] mergeSort1) {
        int[] result = new int [mergeSort.length + mergeSort1.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = mergeSort[a] < mergeSort1[b] ? mergeSort[a++] : mergeSort1[b++];
            if (a == mergeSort.length){
                System.arraycopy(mergeSort1, b, result, ++i, mergeSort1.length - b);
                break;
            }
            if (b == mergeSort1.length){
                System.arraycopy(mergeSort,a, result, ++i, mergeSort.length - a);
                break;
            }

        }
        return result;
    }


}
