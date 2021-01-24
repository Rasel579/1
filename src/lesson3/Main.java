package lesson3;
import lesson2.Main.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    //Задание 3.1
    //На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
    //Оцените время выполнения преобразования.
    public static int[] array = new int[5];
    public static Random random = new Random(13);
    public static long a;


    public static void main(String[] args) {
        for (int i = 0; i <array.length; i++) {
            array[i] = random.nextInt(12);
            System.out.print(array[i]);
        }
        a = System.nanoTime();

        LinkedList<Integer> linkedListArr = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            linkedListArr.add(array[i]);
        }
        System.out.println(linkedListArr + " " + (System.nanoTime() - a));

        //Задание 3.2
        //На основе списка из задания 3.1 реализуйте основные методы добавления,
        // удаления и получения объекта или элемента из списка.
        //Оценить выполненные методы с помощью базового класса System.nanoTime().
        a = System.nanoTime();
        linkedListArr.add(2);
        linkedListArr.add(3);
        linkedListArr.remove(3);
        System.out.println(linkedListArr + " " + (System.nanoTime() - a));

        //Задание 3.3
        //Реализуйте простой односвязный список и его базовые методы.
        LinkedLs linkedLs = new LinkedLs(2,3);
        linkedLs.add(3,5);
        linkedLs.add(23,56);
        linkedLs.add(80,90);
        System.out.println(linkedLs.toString());
        linkedLs.print();
//        linkedLs.delete(3,5);
//        System.out.println(linkedLs.toString());
//        linkedLs.delete(2,3);
//        System.out.println(linkedLs.toString());

        //Задание 3.4
        //На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        //Реализуйте список заполненный объектами из вашего класса из задания 1.3

        CirceLinkedLs circeLinkedLs = new CirceLinkedLs(3,5);
        circeLinkedLs.add(33, 44);
        circeLinkedLs.add(34, 54);
        circeLinkedLs.add(55, 77);
        System.out.println(circeLinkedLs.toString());
        circeLinkedLs.print();
        circeLinkedLs.delete(34,54);
        System.out.println(circeLinkedLs.toString());


        //Задание 3.5
        //Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime()
        while (linkedLs.hasNext()){
            linkedLs = linkedLs.next();
        }




    }





}
