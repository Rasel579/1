package lesson6;

public class Node {
    public Person currentPerson;
    public Node leftChildren;
    public Node rightChildren;
    Node(Person person){
        this.currentPerson = person;
    }
    public void show(){
        System.out.println("Name " + currentPerson.name + " age " + currentPerson.age + " id " + currentPerson.id);
    }
}
