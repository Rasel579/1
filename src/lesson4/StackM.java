package lesson4;

public class StackM {
    private int maxSize;
    private ObjClass[] stack;
    private int top;

    StackM(int maxSize){
        stack = new ObjClass[maxSize];
        this.maxSize = maxSize;
        top = -1;
    }

  public ObjClass push(ObjClass obj){
        return this.stack[++this.top] = obj;
  }

  public  ObjClass pop(){
        return this.stack[top--];
  }

  public ObjClass peak () {
        return this.stack[top];
  }

  public boolean isEmpty(){
        return top == -1;
  }

}
