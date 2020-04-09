import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static Double[][][] createDoubleArray(int n, int m, int l) {
        Random rand = new Random(n+m+l);
        Double[][][] dArr = new Double[n][m][l];
        for(int i = 0; i < n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<l; k++) {
                    if (k!=0)
                        dArr[i][j][k] = Math. min(Math.min(n, m), l) + rand.nextDouble();
                }
            }
        }
        return dArr;
    }
    public static void printArray(Double[][][] a) {
//        for(int i=0; i < a.length; i++) {
//            if(i == 0) System.out.print("{ ");
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.print(Arrays.toString(a[i]) + ", ");
//            }
//            if(i == a[i].length-1)
//                System.out.println(" }");
//            else
//                System.out.println();
//        }
        System.out.println(Arrays.deepToString(a));
    }
    public static void main(String[] args) {
        printArray(createDoubleArray(3, 2, 2));
    }
}
