package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Pow extends Operators {
    private static final Logger logger = Logger.getLogger(Pow.class);

    @Override
    public String compute(Integer a, Integer b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        try {
            BigInteger result = bigIntegerA.pow(b);
            return result.toString();
        } catch (ArithmeticException e) {
            logger.error("Error in Pow.class", e);
            return "This calculator can't work with negative pow or with very big range!";
        }
    }
}
