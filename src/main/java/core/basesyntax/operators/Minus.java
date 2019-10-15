package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Minus extends Operators {
    private static final Logger logger = Logger.getLogger(Minus.class);

    @Override
    public int compute(int a, int b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        try {
            return bigIntegerA.subtract(bigIntegerB).intValueExact();
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException in Minus class ", e);
            throw new ArithmeticException("ArithmeticException while  subtracting " + e);
        }
    }
}
