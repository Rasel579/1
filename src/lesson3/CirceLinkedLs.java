package lesson3;

public class CirceLinkedLs {
    static class Link{
        private int x;
        private int y;

        public Link(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return
                    "x=" + x +
                            ", y=" + y;

        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    private Link link;
    private CirceLinkedLs next;
    private CirceLinkedLs prev = null;
    private boolean first = true;
    CirceLinkedLs(int x, int y){
        this.link = new Link(x, y);
    }

    public Link getLink() {
        return link;
    }


    @Override
    public String toString() {
        return "CircleLinkedList{" +
                "link=" + link.toString() + " " +
                "next" + next +
                '}';
    }

    public void add(int x , int y){
        if(first){
            CirceLinkedLs ls = this;
            this.next = new CirceLinkedLs(x,y);
            this.prev = ls;
            this.first = false;
            System.out.println("Текущий " + this);
            System.out.println("Пред " + this.prev);
            System.out.println("След " +this.next);

        } else {
            CirceLinkedLs ls = this.next;
            ls.add(x,y);
        }
    }
    public void print(){
        System.out.println(link.toString());
    }

    public void  delete(int x, int y){
        if(link.x == x && link.y == y){
            this.link = this.next.link;
            this.next = this.next.next;
            this.prev =  this.prev.prev;
        } else {
            CirceLinkedLs ls = this.next;
            ls.delete(x, y);
        }
    }

}
