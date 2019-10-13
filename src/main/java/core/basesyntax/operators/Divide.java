package core.basesyntax.operators;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Divide extends Operators {
    private static final Logger logger = Logger.getLogger(Divide.class);

    @Override
    public String compute(Integer a, Integer b) {
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        try {
            BigInteger result = bigIntegerA.divide(bigIntegerB);
            return result.toString();
        } catch (ArithmeticException e) {
            logger.error("Try divide by zero ", e);
            return "You can't divide by zero!";
        }
    }
}
