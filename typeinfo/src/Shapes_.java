import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitriy on 21.01.2020.
 */
class Shape_ {
    boolean flag = false;
    void draw() {
        System.out.println(this + ".draw()");}

    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted " + this.getClass().getSimpleName();
    }
}

class Circle_ extends Shape_ {}
class Square_ extends Shape_ {}
class Triangle_ extends Shape_ {}
class Romboid_ extends Shape_ {}

public class Shapes_ {
    public static void rotate(Shape_ s) {
        if(!(s instanceof Circle_))
            System.out.println(s + " rotate");
    }

    public static void setFlags(Shape_ s) {
        if(s instanceof Square_)
            ((Square_) s).flag = true;
    }

    public static void main(String[] args) {
        List<Shape_> shapeList = Arrays.asList(
                new Circle_(), new Square_(), new Triangle_(), new Romboid_(),
                new Circle_(), new Romboid_());
        for(Shape_ shape : shapeList) {
                shape.draw();
                rotate(shape);
        }
        if((shapeList.get(0)) instanceof Romboid_)
            ((Romboid_) shapeList.get(3)).draw();
        System.out.print("Нисходящее преобразование: ");
        ((Circle_) shapeList.get(0)).draw();

        System.out.println("*** Выделение ***");

        for (Shape_ sh : shapeList) {
            setFlags(sh);
            if(sh.flag) {
                sh.draw();
            }
        }
    }
}
