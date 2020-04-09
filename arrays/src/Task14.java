import util.CountingGenerator;
import util.Generated;
import util.Generator;

import java.util.Arrays;

import static util.Print.print;

public class Task14 {
    public static boolean[] showBooleanArray(boolean[] b) {
        CountingGenerator.Boolean cgb = new CountingGenerator.Boolean();
        for (int i=0; i<b.length; i++)
            b[i] = cgb.next();
        return b;
    }

    public static void main(String[] args) throws Exception {
        int size = 5;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];

        a1 = showBooleanArray(a1);
        a2 = showByteArray(a2);
        a3 = showCharArray(a3);
//        a4 = showShortArray(a4);
//        a5 = showIntegerArray(a5);
//        a6 = showLongArray(a6);
//        a7 = showFloatArray(a7);
//        a8 = showDoubleArray(a8);

        print("boolean: " + Arrays.toString(a1));
        print("byte: " + Arrays.toString(a2));
        print("char: " + Arrays.toString(a3));
    }

    private static char[] showCharArray(char[] a) {
        CountingGenerator.Character cgc = new CountingGenerator.Character();
        for (int i=0; i < a.length; i++)
            a[i] = cgc.next();
        return a;
    }

    private static byte[] showByteArray(byte[] a) {
        CountingGenerator.Byte cgb = new CountingGenerator.Byte();
        for(int i=0; i< a.length; i++)
            a[i] = cgb.next();
        return a;
    }
}
