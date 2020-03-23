import java.util.Iterator;
import java.util.Random;

import shape.Circle;
import shape.Shape;
import shape.Square;
import shape.Triangle;

public class RandomShapeGenerator implements Iterable<Shape> {
    private Random rand = new Random(47);
    private int counter;
    private Shape[] shapes;

    RandomShapeGenerator(int count) {
        this.counter = count;
        shapes = new Shape[count];
        for(int i=0; i<count; i++) {
            switch (rand.nextInt(3)) {
                default:
                case 0: {
                    shapes[i] = new Circle();
                    break; }
                case 1: {
                    shapes[i] = new Square();
                    break; }
                case 2: {
                    shapes[i] = new Triangle();
                    break; }
            }
        }
    }

    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            public boolean hasNext() {
                return index < counter;
            }

            public Shape next() {
                return shapes[index++];
            }
        };
    }

    public static void main(String[] args) {

        RandomShapeGenerator gen = new RandomShapeGenerator(9);
        Iterator<Shape> iterator = gen.iterator();

        Shape shp;
        while (iterator.hasNext()) {
            shp = iterator.next();
            shp.draw();
            shp.erase();
        }
    }
}
