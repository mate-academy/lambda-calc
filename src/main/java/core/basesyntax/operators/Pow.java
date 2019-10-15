package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Pow extends Operators {
    private static final Logger logger = Logger.getLogger(Pow.class);

    @Override
    public int compute(int a, int b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        try {
            BigInteger result = bigIntegerA.pow(b);
            return result.intValueExact();
        } catch (ArithmeticException e) {
            logger.error("Error in Pow class ", e);
            throw new ArithmeticException("ArithmeticException while exponentiation " + e);
        }
    }
}
