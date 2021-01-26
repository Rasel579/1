package lesson4;

public class PriorityQueue {
    static class  Link{
        private Integer data;
        private int priority;
        Link(Integer a, int  priority){
            data = a;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "data=" + data +
                    ", priority=" + priority +
                    '}';
        }

        public Integer getData() {
            return data;
        }
    }

    private  Link link;
    private PriorityQueue next;
    private PriorityQueue prev;
    private boolean min;
    private boolean max;

    PriorityQueue(Integer x, int y){
        link = new Link(x,y);
        next = null;
        prev = null;
        min = true;
        max = true;
    }

//    @Override
//    public String toString() {
//        return
//                "link=" + link +
//                ", next=" + next +
//                ", prev=" + prev +
//                ", min=" + min +
//                '}';
//    }

    public  void push(Integer a, int b){
        if (b < this.link.priority && this.min ){
            this.prev = new PriorityQueue(a,b);
            this.min = false;
            this.prev.min = true;
            this.prev.max = false;
            this.prev.next = this;
        }
        else if (b > this.link.priority && this.max) {
            this.next = new PriorityQueue(a,b);
            this.next.prev = this;
            this.max = false;
            this.next.max = true;
            this.next.min = false;

        }
        else if(this.prev != null && this.prev.link.priority > b){
            this.prev.push(a,b);
        }
        else if(this.next != null && this.next.link.priority < b) {
            this.next.push(a,b);
        }

        else if (this.prev.link.priority < b && this.link.priority > b){
            PriorityQueue temp = this.prev;
            this.prev  = new PriorityQueue(a,b);
            this.prev.prev = temp;
            this.prev.next = this;
            this.prev.min = false;
            this.prev.max = false;
        }
        else if (this.next.link.priority >  b && this.link.priority < b){
            PriorityQueue temp = this.next;
            this.next  = new PriorityQueue(a,b);
            this.next.next = temp;
            this.next.prev = this;
            this.next.min = false;
            this.next.max = false;
        }

    }

    public  void  printAllPrevLink(){
        if(min){
            System.out.printf("Data: %s, Priority: %s ",this.link.data, this.link.priority);
            return;
        }
        System.out.printf("Prev Links Data: %s, Priority: %s ",this.link.data, this.link.priority);
        this.prev.printAllPrevLink();
    }

    public  void  printAllNextLink(){
        if(this.next == null){
             System.out.printf("Data: %s, Priority: %s ",this.link.data, this.link.priority);
             return;
        }
        System.out.printf("\n NextLinks Data: %s, Priority: %s ",this.link.data, this.link.priority);
        this.next.printAllNextLink();
    }



}
