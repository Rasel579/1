package lesson4;

public class StackLs {
    static class Link{
        private int x;
        private int y;

        @Override
        public String toString() {
            return "Link{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        Link(int a, int b){
            x = a;
            y = b;
        }

        public void print(){
            System.out.println("StackList " +this.toString());
        }
    }

    public   Link link;
    private boolean first;
    private StackLs next = null;
    private StackLs prev;
    private int top = 0;

    StackLs(int x, int y){
        link = new Link(x,y);
        first = true;
        prev = null;
        top = 0;
    }

    public void push(int x , int y){
        if(first){
            this.next = new StackLs(x, y);
            this.next.prev = this;
            this.first = false;
            this.next.top++;
        }
        else  this.next.push(x, y);
    }

    public StackLs pop(){
        if(first && this.next == null && this.prev != null){
            this.prev.next = null;
            this.prev.first = true;
            return this;
        }
       else if(this.next != null) {
           return this.next.pop();
       };
        return null;
    }

    public  boolean isEmpty(){
        if(this.next == null){
            return true;
        }
        return false;
    }


}
