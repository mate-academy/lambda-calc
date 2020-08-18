package core.basesyntax;

import java.io.IOException;

/**
 * Feel free to remove this class and create your own.
 */
public class SimpleCalculator {
    public static double calculate(double a, Character sign, double b) throws IOException {
        if (sign.equals('+')) {
            return (a + b);
        }

        if (sign.equals('-')) {
            return (a - b);
        }

        if (sign.equals('*') || sign.equals('•')) {
            return (a * b);
        }

        if (sign.equals('/') || sign.equals(':')) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero exception");
            }
            return (double) a / (double) b;
        }

        if (sign.equals('^')) {
            return Math.pow(a, b);
        }
        throw new IOException("\" " + sign + "\" is unknown operator");
    }

}
