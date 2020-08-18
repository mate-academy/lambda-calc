package core.basesyntax;

public class Calculator {
    private static final char ADDITION_SIGN = '+';
    private static final char SUBTRACTION_SIGN = '-';
    private static final char DIVISION_SIGN = '/';
    private static final char MULTIPLICATION_SIGN = '*';
    private static final char RAISING_TO_THE_POWER = '^';

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case ADDITION_SIGN : {
                return addition(first, second);
            }
            case SUBTRACTION_SIGN : {
                return subtraction(first, second);
            }
            case DIVISION_SIGN : {
                return division(first, second);
            }
            case MULTIPLICATION_SIGN : {
                return multiplication(first, second);
            }
            case RAISING_TO_THE_POWER : {
                return raisingToThePower(first, second);
            }
            default : throw new IllegalArgumentException("Unknown operation");
        }
    }

    private double addition(double first, double second) {
        return first + second;
    }

    private double subtraction(double first, double second) {
        return first - second;
    }

    private double division(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Division by 0");
        }
        return first / second;
    }

    private double multiplication(double first, double second) {
        return first * second;
    }

    private double raisingToThePower(double first, double second) {
        return Math.pow(first, second);
    }
}
