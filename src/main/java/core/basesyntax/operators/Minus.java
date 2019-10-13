package core.basesyntax.operators;

import java.math.BigInteger;

public class Minus extends Operators {

    @Override
    public String compute(Integer a, Integer b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        return bigIntegerA.subtract(bigIntegerB).toString();
    }
}
