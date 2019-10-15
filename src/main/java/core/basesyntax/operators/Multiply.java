package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Multiply extends Operators {
    private static final Logger logger = Logger.getLogger(Multiply.class);

    @Override
    public int compute(int a, int b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        try {
            return bigIntegerA.multiply(bigIntegerB).intValueExact();
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException in Multiply class ", e);
            throw new ArithmeticException("ArithmeticException while multiplication " + e);
        }
    }
}
