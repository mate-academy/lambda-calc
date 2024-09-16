package core.basesyntax;

import core.basesyntax.exceptions.InfinityException;
import core.basesyntax.exceptions.UnexpectedOperandException;

public class CalculationLogic {
    private static final char DIVIDE = '/';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char PLUS = '+';
    private static final char POWER = '^';

    public double calculation(double value1, double value2, char operand) {
        switch (operand) {
            case PLUS: {
                return addition(value1, value2);
            }
            case MINUS: {
                return subtraction(value1, value2);
            }
            case MULTIPLY: {
                return multiplication(value1, value2);
            }
            case DIVIDE: {
                return division(value1, value2);
            }
            case POWER: {
                return power(value1, value2);
            }
            default:
                throw new UnexpectedOperandException("Unexpected operation. Only addition, "
                        + "subtraction, multiplication, division and power allowed");
        }
    }

    private double addition(double value1, double value2) {
        return value1 + value2;
    }

    private double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    private double multiplication(double value1, double value2) {
        if (value1 == 0 && value2 < 0) {
            return 0;
        }
        if (Double.isInfinite(value1 * value2)) {
            throw new InfinityException("Result is infinity");
        }
        return value1 * value2;
    }

    private double division(double value1, double value2) {
        if (value2 == 0) {
            throw new ArithmeticException("can't divide by 0");
        }
        return value1 / value2;
    }

    private double power(double value1, double value2) {
        if (Double.isInfinite(Math.pow(value1, value2)) && value1 > 0 && value2 > 0) {
            throw new InfinityException("Result is infinity");
        }
        return Math.pow(value1, value2);
    }
}
