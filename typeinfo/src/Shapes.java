import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitriy on 21.01.2020.
 */
abstract class Shape {
    boolean flag = false;
    void draw() {
        System.out.println(this + ".draw()");}

//    public String toString() {
//        return (flag ? "H" : "Unh") + "ighlighted " + this.getClass().getSimpleName();
//    }
}

class Circle extends Shape {
//    public String toString() {
//        return "Circle";
//    }
    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted Circle";
    }
}

class Square extends Shape {

    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted Square";
    }
}

class Triangle extends Shape {

    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted Triangle";
    }
}

class Romboid extends Shape {

    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted Romboid";
    }
}

public class Shapes {
    public static void rotate(Shape s) {
        if(!(s instanceof Circle))
            System.out.println(s + " rotate");
    }

    public static void setFlags(Shape s) {
        if(s instanceof Circle)
            ((Circle) s).flag = true;
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Romboid(),
                new Circle(), new Romboid());
        for(Shape shape : shapeList) {
                shape.draw();
                rotate(shape);
        }
        if((shapeList.get(0)) instanceof Romboid)
            ((Romboid) shapeList.get(3)).draw();
        System.out.print("Нисходящее преобразование: ");
        ((Circle) shapeList.get(0)).draw();

        System.out.println("*** Выделение ***");

        for (Shape sh : shapeList) {
            setFlags(sh);
            if(sh.flag) {
                sh.draw();
            }
        }
    }
}
