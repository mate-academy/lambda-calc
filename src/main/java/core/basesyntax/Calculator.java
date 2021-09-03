package core.basesyntax;

import java.util.NoSuchElementException;

public class Calculator {
    public static final String DIVIDE_ON_ZERO_MESSAGE = "We can't divide on 0!";

    public double calculate(double first, double second, Operations operation) {
        switch (operation) {
            case PLUS:
                return getAdditionResult(first, second);
            case MINUS:
                return getSubtractionResult(first, second);
            case MULTIPLY:
                return getMultiplicationResult(first, second);
            case DIVIDE:
                return getDivisionResult(first, second);
            case POW:
                return getPowResult(first, second);
            default:
                throw new NoSuchElementException("Operation " + operation + " doesn't exist!");
        }
    }

    private double getAdditionResult(double first, double second) {
        return first + second;
    }

    private double getSubtractionResult(double first, double second) {
        return first - second;
    }

    private double getMultiplicationResult(double first, double second) {
        return first * second;
    }

    private double getDivisionResult(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException(DIVIDE_ON_ZERO_MESSAGE);
        }
        return first / second;
    }

    private double getPowResult(double first, double second) {
        return Math.pow(first, second);
    }
}
