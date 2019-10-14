package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Sum extends Operators {
    private static final Logger logger = Logger.getLogger(Sum.class);

    @Override
    public int compute(int a, int b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        try {
            return bigIntegerA.add(bigIntegerB).intValueExact();
        } catch (ArithmeticException e) {
            logger.error("Error in Sum class ", e);
            throw new ArithmeticException("ArithmeticException while adding " + e);
        }
    }
}
