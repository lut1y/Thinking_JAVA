/**
 * Created by Dmitriy on 20.01.2020.
 */
public class Task20 {
    int i;
    long l;
    float f;
    double d;
    String s;

    public Task20(String s) {
        String[] arrayEl = s.split(" ");
        i = Integer.parseInt(arrayEl[0]);
        l = Long.parseLong(arrayEl[1]);
        f = Float.parseFloat(arrayEl[2]);
        d = Double.parseDouble(arrayEl[3]);
        this.s = arrayEl[4];
    }

    public static void main(String[] args) {
        Task20 t20 = new Task20("20 1000000 1.6f 0.0809015 word");
        System.out.format("i = %d\nl = %d\nf = %2.3f\nd = %f\ns = %s",
                t20.i, t20.l, t20.f, t20.d, t20.s);
    }
}
