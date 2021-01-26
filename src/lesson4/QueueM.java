package lesson4;

public class QueueM {
    private int maxSize;
    private ObjClass[] queue;
    private int first;
    private int last;
    QueueM(int size){
        queue = new ObjClass[size];
        first = -1;
        last =  0;
    }

    public  ObjClass insert(ObjClass objClass){
        if(last == maxSize - 1)
            last = - 1;
        return  queue[last++] = objClass;
    }

    public ObjClass pop(){
        return  queue[++first];
    }

    public boolean isEmpty(){
        return last - 1== first;
    }

    public boolean isFull(){
        return  last == maxSize - 1;
    }

    public void peak(){
        queue[first + 1].print();
    }
}
