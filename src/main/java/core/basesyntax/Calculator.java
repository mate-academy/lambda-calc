package core.basesyntax;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTI = '*';
    private static final char DIVIDE = '/';
    private static final char POW = 'p';
    private static final char POW_UP = 'P';

    public double calculate(double a, double b, char whatToDo) {
        switch (whatToDo) {
            case PLUS:
                return addition(a, b);
            case MINUS:
                return subtraction(a, b);
            case DIVIDE:
                return division(a, b);
            case MULTI:
                return multiplication(a, b);
            case POW:
            case POW_UP:
                return power(a, b);
            default:
                throw new RuntimeException("Wrong operation");
        }
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double power(double a, double b) {
        return Math.pow(a,b);
    }

    private double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Human can't divide by zero");
        }
        return new BigDecimal(a).divide(new BigDecimal(b),2, RoundingMode.UP).doubleValue();
    }

}
