import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();
        ls[1] = new ArrayList<String>();

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

        List<BerylluimSphere>[] spheres =
                (List<BerylluimSphere>[]) new List[10];
        for(int i=0; i < spheres.length; i++)
            spheres[i] = new ArrayList<BerylluimSphere>();
    }
}
