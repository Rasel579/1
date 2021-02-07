package lesson4;

public class QueueLs {
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
            System.out.println(this.toString());
        }
    }

    public Link link;
    private boolean first;
    private boolean last;
    private QueueLs next;
    private QueueLs prev;
    private int top = 0;

    QueueLs(int x, int y){
        link = new Link(x,y);
        first = true;
        last = true;
        prev = null;
        top = 0;
    }

    public void push(int x , int y){
        if(last){
            this.next = new QueueLs(x, y);
            this.next.prev = this;
            this.last = false;
            this.next.first = false;
            this.next.top++;

        }
        else  this.next.push(x, y);
    }

    public QueueLs pop(){
        QueueLs pop = this;
        if(first && this.next != null){
            pop = this.next;
            pop.first = true;
            pop.prev = null;
            this.first = false;
            return this;

        }
        else if(this.next != null) {
            return this.next.pop();
        };
        return pop;
    }

    public  boolean isEmpty(){
        if(this.next == null && this.prev == null ){
            return true;
        }
        return false;
    }

    public void print(){
        System.out.println("Queue " + this.link);
    }
}
