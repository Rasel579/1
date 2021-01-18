package lesson1;

public class MyClass {
    private int height;
    private  int length;
    private String name;


    MyClass(String name, int height, int length){
        this.height = height;
        this.length = length;
        this.name = name;
    }


    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "height=" + height +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    public void show(){
        System.out.println(this.toString());
    }
}
