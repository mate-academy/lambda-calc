package core.basesyntax;

import java.util.NoSuchElementException;

public class Calculator {
    public static final String DIVIDE_ON_ZERO_MESSAGE = "We can't divide on 0!";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String POW = "^";

    public double calculate(double first, double second, String operation) {
        switch (operation) {
            case "+":
                return getAdditionResult(first, second);
            case "-":
                return getSubtractionResult(first, second);
            case "*":
                return getMultiplicationResult(first, second);
            case "/":
                return getDivisionResult(first, second);
            case "^":
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
