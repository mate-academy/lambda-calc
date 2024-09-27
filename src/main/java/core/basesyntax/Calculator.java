package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char sign) {
        if (sign == '+') {
            return addition(a, b);
        }
        if (sign == '-') {
            return subtraction(a, b);
        }
        if (sign == '/') {
            return division(a, b);
        }
        if (sign == '*') {
            return multiplication(a, b);
        }
        if (sign == '^') {
            return power(a, b);
        }
        throw new IllegalArgumentException("You entered wrong sign");
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("We can't divide by zero");
        }
        return a / b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double power(double a, double b) {
        return Math.pow(a, b);
    }
}
