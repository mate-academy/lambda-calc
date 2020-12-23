package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            case '^':
                return pow(a, b);
            default:
                throw new RuntimeException("No such operation exception: " + operator);
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return a / b;
    }

    private double pow(double a, double b) {
        return Math.pow(a, b);
    }

}
