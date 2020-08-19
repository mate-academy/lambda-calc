package core.basesyntax;

public class Calculator {

    public double calculate(double x, double y, char operator) {
        switch (operator) {
            case '+':
                return addition(x, y);
            case '-':
                return subtraction(x, y);
            case '*':
                return multiplication(x, y);
            case '/':
                return division(x, y);
            case '^':
                return power(x, y);
            default:
                throw new IllegalArgumentException("Wrong sign");
        }
    }

    private double addition(double x, double y) {
        return x + y;
    }

    private double subtraction(double x, double y) {
        return x - y;
    }

    private double multiplication(double x, double y) {
        return x * y;
    }

    private double division(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Can't div by zero");
        }
        return x / y;
    }

    private double power(double x, double y) {
        return Math.pow(x, y);
    }
}
