package lesson4;

public class Dequeue {
    private int maxSize;
    private ObjClass[] dequeue;
    private int front;
    private  int back;
    Dequeue(int size){
        dequeue = new ObjClass[size];
        maxSize = size;
        front = 0;
        back = -1;
    }
    public  ObjClass pushBack(ObjClass objClass){
        if (back == maxSize - 1)
            back = -1;
        return dequeue[++back] = objClass;
    }
    public  ObjClass pushFront(ObjClass objClass){
            if(back == maxSize - 1)
                back = maxSize - 2;
            for (int i = 1; i < back+2; i++) {
                dequeue[back + 2 - i ] = dequeue[back + 1 - i];
            }
        dequeue[front] = objClass;
        back++;
        front = 0;
        return dequeue[front];
    }

    public ObjClass popFront(){
        return  dequeue[front++];
    }

    public ObjClass popBack(){
        return dequeue[back--];
    }

    public boolean isEmpty(){
        return back == front - 1;
    }

}
