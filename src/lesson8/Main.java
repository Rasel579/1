package lesson8;

import static java.util.Objects.hash;

public class Main {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable(97);

        hashTable.insert("rhino");
        hashTable.insert("man");
        hashTable.insert("computer");
        hashTable.insert("home");
        hashTable.insert("basket");

        hashTable.print();

        Item item = hashTable.find("man");

        if(item != null)
            System.out.println("Элемент найден!");
        else
            System.out.println("Элемент не найден!");
    }
}


