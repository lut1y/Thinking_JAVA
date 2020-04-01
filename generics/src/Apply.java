import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static util.Print.print;

public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for(T t : seq)
                f.invoke(t, args);
        } catch(Exception e) {
            // Сбои являются ошибками программиста
            throw new RuntimeException(e);
        }
    }
}

class ShapE {
    public void rotate() { print(this + " rotate"); }
    public void resize(int newSize) { print(this + " resize " + newSize); }
}

class SquarE extends ShapE {}

class FilledLisT<T> extends ArrayList<T> {
    public FilledLisT(Class<? extends T> type, int size) {
        try {
            for(int i=0; i<size; i++)
                add(type.newInstance());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest {
    public static void main(String[] args) throws Exception {
        List<ShapE> shapes = new ArrayList<ShapE>();
        for(int i=0; i < 10; i++)
            shapes.add(new ShapE());
        Apply.apply(shapes, ShapE.class.getMethod("rotate"));
        Apply.apply(shapes, ShapE.class.getMethod("resize", int.class), 5);
        List<SquarE> squares = new ArrayList<SquarE>();
        for(int i=0; i<10; i++)
            squares.add(new SquarE());
        Apply.apply(squares, ShapE.class.getMethod("rotate"));
        Apply.apply(squares, ShapE.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledLisT<ShapE>(ShapE.class, 10), ShapE.class.getMethod("rotate"));
        Apply.apply(new FilledLisT<ShapE>(ShapE.class, 10), ShapE.class.getMethod("rotate"));

        SimpleQueue<ShapE> shapeQ = new SimpleQueue<ShapE>();
        for(int i=0; i<5; i++) {
            shapeQ.add(new ShapE());
            shapeQ.add(new SquarE());
        }
        Apply.apply(shapeQ, ShapE.class.getMethod("rotate"));
    }
}