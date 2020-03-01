import java.util.Arrays;
import java.util.List;

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String toString() {
        return "MyObject: " + name;
    }
}

public class Task2<T> {
    private T x, y, z;
    public Task2(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public T getX() {return x;}
    public T getY() {return y;}
    public T getZ() {return z;}

    public void setX(T x) {this.x = x;}
    public void setY(T y) {this.y = y;}
    public void setZ(T z) {this.z = z;}

    public static void main(String[] args) {
        Task2<MyObject> theeObjects = new Task2<MyObject>(new MyObject("Камень"),
                new MyObject("Ножницы"), new MyObject("Бумага"));
        System.out.println(theeObjects.getX());
        System.out.println(theeObjects.getY());
        System.out.println(theeObjects.getZ());
        theeObjects.setX(new MyObject("Stone"));
        theeObjects.setY(new MyObject("Scissors"));
        theeObjects.setZ(new MyObject("Paper"));
        System.out.println(theeObjects.getX());
        System.out.println(theeObjects.getY());
        System.out.println(theeObjects.getZ());
    }
}
