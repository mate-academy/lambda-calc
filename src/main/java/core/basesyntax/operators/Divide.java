package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Divide extends Operators {
    private static final Logger logger = Logger.getLogger(Divide.class);

    @Override
    public int compute(int a, int b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        try {
            BigInteger result = bigIntegerA.divide(bigIntegerB);
            return result.intValueExact();
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException in Divide class ", e);
            throw new ArithmeticException("ArithmeticException while dividing " + e);
        }
    }
}
