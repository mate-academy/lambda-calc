package core.basesyntax;

public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char POWERING = '^';

    public double calculate(double num1, double num2, char sign) {
        switch (sign) {
            case PLUS:
                return sum(num1, num2);
            case MINUS:
                return substract(num1, num2);
            case MULTIPLY:
                return multiple(num1, num2);
            case DIVIDE:
                return divide(num1, num2);
            case POWERING:
                return power(num1, num2);
            default:
                throw new IllegalArgumentException("This sign is not correct");
        }
    }

    private static double sum(double num1, double num2) {
        return num1 + num2;
    }

    private static double substract(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiple(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("You cant divide by zero!");
        }
        return num1 / num2;
    }

    private static double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}
