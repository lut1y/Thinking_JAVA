import util.Generated;
import util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

class BigDecimalGenerator implements Generator<BigDecimal> {

    public BigDecimal next() {
        return new BigDecimal("0.0");
    }
}

public class Task17 {
    public static void main(String[] args) {
        BigDecimal[] bd = new BigDecimal[5];
        BigDecimal[] bd1 = Generated.array(bd, new BigDecimalGenerator());
        System.out.println(Arrays.toString(bd1));
    }
}
