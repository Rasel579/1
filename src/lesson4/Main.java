package lesson4;

public class Main {
    public static void main(String[] args) {
        //Задание 4.1
        //На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
           long a = System.nanoTime();
           StackM stackM = new StackM(5);
           stackM.push(new ObjClass(3,4));
           stackM.push(new ObjClass(7,5));
           stackM.push(new ObjClass(4,6));
           stackM.push(new ObjClass(4,6));
           System.out.println(System.nanoTime() - a);
           a = System.nanoTime();
           while (!stackM.isEmpty())
           { stackM.pop().print();
           }
           System.out.println(System.nanoTime() - a);

        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Задание 4.2
        //На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        //Реализуйте вспомогательные методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

          QueueM queueM = new QueueM(5);
          queueM.insert(new ObjClass(3,4));
          queueM.insert(new ObjClass(4,5));
          queueM.insert(new ObjClass(44,22));
          queueM.insert(new ObjClass(46,76));
          queueM.peak();
          while (!queueM.isEmpty()){
              queueM.pop().print();
          }

        //Задание 4.3
        //На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

           Dequeue dequeue = new Dequeue(6);
          a = System.nanoTime();
          dequeue.pushBack(new ObjClass(3,3));
          System.out.println(System.nanoTime() - a);
          dequeue.pushBack(new ObjClass(4,4));
          dequeue.pushBack(new ObjClass(5,5));
          dequeue.pushBack(new ObjClass(6,6));
          a = System.nanoTime();
          dequeue.pushFront(new ObjClass(7,7));
          System.out.println(System.nanoTime() - a);
          dequeue.pushFront(new ObjClass(8,8));
          a = System.nanoTime();
          while (!dequeue.isEmpty()){
              dequeue.popBack().print();
          }
         System.out.println(System.nanoTime() - a);
        //Задание 4.4
        //Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

           PriorityQueue priorityQueue = new PriorityQueue(2, 10);
           priorityQueue.push(3,9);
           priorityQueue.push(4,7);
           priorityQueue.push(4,8);
           priorityQueue.push(4,12);
           priorityQueue.push(4,11);
           priorityQueue.printAllPrevLink();
           priorityQueue.printAllNextLink();

        //Задание 4.5
        //На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

        StackLs stackLs = new StackLs(2,3);
        stackLs.push(3,4);
        stackLs.push(5,5 );
        stackLs.push(6,56 );
        stackLs.push(55,55 );
         while (!stackLs.isEmpty()){
             stackLs.pop().link.print();
         }


         QueueLs queueLs = new QueueLs(5, 5);
         queueLs.push(6,6);
         queueLs.push(8,8);
         queueLs.push(9,65);
         queueLs.push(77,76);
         QueueLs newQueue = queueLs;
        while (!newQueue.isEmpty()){
            newQueue = queueLs.pop();
            newQueue.print();
        }


    }
}


