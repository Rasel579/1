package lesson4;

public class ObjClass {
    private  int x;
    private  int y;
    ObjClass(int x, int y){
        this.x = x;
        this.y =y;
    }

    public  void  print (){
        System.out.println(this.x + " " + this.y);
    }
}
