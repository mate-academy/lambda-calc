package core.basesyntax;

public class Calculator {

    public double calculate(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return addition(num1, num2);
            case '-':
                return subtraction(num1, num2);
            case '*':
                return multiplication(num1, num2);
            case '/':
                return division(num1, num2);
            case '^':
                return power(num1, num2);
            default:
                throw new IllegalArgumentException("Operation in not valid");
        }
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return a / b;
    }

    private double power(double num, double power) {
        return Math.pow(num, power);
    }
}
