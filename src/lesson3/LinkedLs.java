package lesson3;


import java.util.Iterator;

public class LinkedLs implements Iterator {
    @Override
    public boolean hasNext() {
        if (this.next != null){
            return  true;
        } else return false;
    }

    @Override
    public LinkedLs next() {
        LinkedLs ls = this;
        ls = this.next;
        System.out.println(this);
        return ls;
    }

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
    private LinkedLs next;
    private boolean first = true;
    LinkedLs(int x, int y){
        this.link = new Link(x, y);
    }

    public Link getLink() {
        return link;
    }


    @Override
    public String toString() {
        return "LinkedLs{" +
                "link=" + link.toString() + " " +
                "next= " + next +
                '}';
    }

    public void add(int x , int y){
        if(first){
            this.next = new LinkedLs(x,y);
            this.first = false;
        } else {
            LinkedLs ls = this.next;
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
        } else {
            LinkedLs ls = this.next;
            ls.delete(x, y);
        }
    }
}