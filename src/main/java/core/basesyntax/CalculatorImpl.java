package core.basesyntax;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double a, double b, char operation) {
        if (operation == '*') {
            return multiply(a, b);
        }
        if (operation == '+') {
            return add(a, b);
        }
        if (operation == '-') {
            return subtract(a, b);
        }
        if (operation == '/') {
            return div(a, b);
        }
        if (operation == '^') {
            return pow(a, b);
        }
        throw new IllegalArgumentException("Not defined function");
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divide on zero");
        }
        return a / b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double pow(double a, double power) {
        return Math.pow(a, power);
    }
}
