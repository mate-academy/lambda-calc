package core.basesyntax;

public class Calculator {

    public double calculate(double first, double second, char operation) {
        double result;
        switch (Character.toLowerCase(operation)) {
            case '+':
                result = addition(first, second);
                break;
            case '-':
                result = subtraction(first, second);
                break;
            case '/':
                result = division(first, second);
                break;
            case '*':
                result = multiplication(first, second);
                break;
            case '^':
                result = raisingToThePower(first, second);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
        return result;
    }

    private double addition(double first, double second) {
        return first + second;
    }

    private double subtraction(double first, double second) {
        return first - second;
    }

    private double division(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Division by zero!");
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
