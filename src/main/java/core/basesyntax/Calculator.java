package core.basesyntax;

import core.basesyntax.exception.DoubleLimitException;
import core.basesyntax.exception.InvalidOperatorException;
import core.basesyntax.exception.NullDivisorException;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLYING = '*';
    private static final char DIVIDING = '/';
    private static final char POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operator) {
        double result;
        switch (operator) {
            case ADDITION:
                result = firstNumber + secondNumber;
                if (result >= Double.MAX_VALUE || result <= -Double.MAX_VALUE) {
                    throw new DoubleLimitException("");
                }
                return result + 0;
            case SUBTRACTION:
                result = firstNumber - secondNumber;
                if (result >= Double.MAX_VALUE || result <= -Double.MAX_VALUE) {
                    throw new DoubleLimitException("");
                }
                return result + 0;
            case MULTIPLYING:
                result = firstNumber * secondNumber;
                if (result >= Double.MAX_VALUE || result <= -Double.MAX_VALUE) {
                    throw new DoubleLimitException("");
                }
                return result + 0;
            case DIVIDING:
                if (secondNumber == 0) {
                    throw new NullDivisorException("");
                }
                result = firstNumber / secondNumber;
                if (result >= Double.MAX_VALUE || result <= -Double.MAX_VALUE) {
                    throw new DoubleLimitException("");
                }
                return result + 0;
            case POWER:
                if (firstNumber == 0 && secondNumber < 0) {
                    throw new NullDivisorException("");
                }
                result = Math.pow(firstNumber, secondNumber);
                if (result >= Double.MAX_VALUE || result <= -Double.MAX_VALUE) {
                    throw new DoubleLimitException("");
                }
                return result;
            default:
                throw new InvalidOperatorException("");
        }
    }
}

