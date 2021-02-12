package lesson6;

import java.net.Socket;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    static Person fistMan = new Person("first", 3,5);
    static Person secondMan = new Person("second", 3,4);
    static Person thirdMan = new Person("third", 3,6);
    static Person fourthMan = new Person("fourth", 34,1);
    static Person fifthMan = new Person("fifth", 34,0);
    static Person sixMan = new Person("six", 34,2);
    static Person sevenMan = new Person("seven", 34,3);
    static Person eightMan = new Person("eight", 34,7);
    static Person nineMan = new Person("nine", 34,8);
    static Person tenMan = new Person("ten", 34,10);

    public static void main(String[] args) {
        //Задание 6.1
        //Приведите пример использования древовидной структуры.

        //В алгоритмах поиска с большими объемами данных


        //Задание 6.2
        //Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.


        //Задание 6.3
        //Реализуйте методы поиска и вставки узла в дерево.
        //Задание 6.4
        //Реализуйте базовые методы обхода дерева и метода дисплей.
        //Реализуйте поиск максимума и минимума.
        //Задание 6.5
        //Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        //Задание 6.6
        //Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        //Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
        //Задание 6.7
        //Приведите пример сбалансированного дерева и его применения.
        System.out.println(fistMan.id);
        System.out.println(secondMan.id);
        System.out.println(thirdMan.id);
        Tree newTree = new Tree();
        newTree.insert(fistMan);
        newTree.insert(secondMan);
        newTree.insert(thirdMan);
        newTree.insert(fourthMan);
        newTree.insert(fifthMan);
        newTree.insert(sixMan);
        newTree.insert(sevenMan);
        newTree.insert(nineMan);
        newTree.insert(eightMan);
        newTree.insert(tenMan);

        newTree.minNode().show();
        newTree.maxNode().show();
        System.out.println("========");
        newTree.display(newTree.root);
        System.out.println("========");
        newTree.delete(4);
        newTree.display(newTree.root);

        int[] a = {3,43,54,6,5,764,43,2,5,3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
