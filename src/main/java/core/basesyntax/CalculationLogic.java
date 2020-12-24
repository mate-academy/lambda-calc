package core.basesyntax;

import core.basesyntax.exceptions.ExpectedException;
import core.basesyntax.exceptions.UnexpectedOperandException;

public class CalculationLogic {
    private static final char DIVIDE = '/';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char PLUS = '+';
    private static final char POWER = '^';

    public double calculation(double a, double b, char operand) {
        switch (operand) {
            case PLUS: {
                return addition(a, b);
            }
            case MINUS: {
                return subtraction(a, b);
            }
            case MULTIPLY: {
                return multiplication(a, b);
            }
            case DIVIDE: {
                return division(a, b);
            }
            case POWER: {
                return power(a, b);
            }
            default:
                throw new UnexpectedOperandException("Unexpected operation. Only addition, "
                        + "subtraction, multiplication, division and power allowed");
        }
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        if (a == 0 && b < 0) {
            return 0;
        }
        if (Double.isInfinite(a * b)) {
            throw new ExpectedException("Result is infinity");
        }
        return a * b;
    }

    private double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("can't divide by 0");
        }
        return a / b;
    }

    private double power(double a, double b) {
        if (Double.isInfinite(Math.pow(a, b)) && a > 0 && b > 0) {
            throw new ExpectedException("Result is infinity");
        }
        return Math.pow(a, b);
    }
}



