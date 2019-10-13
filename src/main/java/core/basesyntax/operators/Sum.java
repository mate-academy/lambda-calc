package core.basesyntax.operators;

import java.math.BigInteger;

public class Sum extends Operators {

    @Override
    public String compute(Integer a, Integer b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        return bigIntegerA.add(bigIntegerB).toString();
    }
}
