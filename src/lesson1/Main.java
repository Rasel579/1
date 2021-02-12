package lesson1;

public class Main {

    public static void main(String[] args) {
        //Задание 1.1
        //Приведите пример алгоритмов и структур данных из жизни.

        //Структура данных из жизни - Картотека библиотеки, телефонная книга, обычная книга
        //Алгоритм готовки по рецепту, поход к врачу, в банк итп


        //Задание 1.2
        //Приведите пример алгоритмов и структур данных в программировании.

        //Алгоритмы поиска и сортировки методом перебора, пузырьковая сортировка

        //Массивы, списки, стеки, куча, дерьвья, графы



        //Задание 1.3
        //Напишите программный код, в котором все данные хранятся только в переменных трех типов данных: Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
        //Выведите написанные данные.
        int numberA = 3;
        int numberB = 2;
        int numberС = 4;
        int numberD = 1;
        int numberE = 5;
        int[] arrayOfNumbers = {numberA, numberB, numberС, numberD, numberE};
        System.out.println(numberA + " " + numberB + " " + numberС + " " + numberD + " " + numberE);
        String word = "Hello";
        System.out.println(word);
        MyClass[] arrayClass = {new MyClass("square", 3, 3 ), new MyClass("triangle", 3, 4), new MyClass("obj", 3, 5)};
        arrayClass[0].show();

        maxNumber(arrayOfNumbers);
        sumCharString(word);
        squareOfObjects(arrayClass);
        long min = Math.min(maxNumber(arrayOfNumbers), sumCharString(word));
        System.out.println("Минимальное время " + " " + Math.min(min, squareOfObjects(arrayClass)));



        //Задание 1.4
        //Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший поиск перебором.
        //Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().


    }

    private static long maxNumber(int[] arrayOfNumbers) {
        int maxNumber = arrayOfNumbers[0];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if(arrayOfNumbers[i] > maxNumber){
                maxNumber = arrayOfNumbers[i];
            }
        }
        System.out.println(maxNumber);
        System.out.println("время maxNumber: " + System.nanoTime());
        return System.nanoTime();
    }

    private static long sumCharString(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            count++;
        }
        System.out.println(count);
        System.out.println("время sumCharString: " + System.nanoTime());
        return System.nanoTime();
    }

    private static long squareOfObjects(MyClass[] arrayClass) {
        int square = arrayClass[0].getHeight() * arrayClass[0].getLength();
        for (int i = 0; i < arrayClass.length; i++) {
            if(arrayClass[i].getHeight()*arrayClass[i].getLength() > square){
                square = arrayClass[i].getHeight()*arrayClass[i].getLength();
            }
        }
        System.out.println(square);
        System.out.println("время squareOfObjects: " + System.nanoTime());
        return System.nanoTime();
    }


}
