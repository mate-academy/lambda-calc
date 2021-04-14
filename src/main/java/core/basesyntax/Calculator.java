package core.basesyntax;

import java.math.BigDecimal;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand,
                            char operation) {
        switch (operation) {
            case '+':
                return addition(firstOperand, secondOperand);
            case '-':
                return subtraction(firstOperand, secondOperand);
            case '*':
                return multiplication(firstOperand, secondOperand);
            case '/':
                return division(firstOperand, secondOperand);
            case '^':
                return pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("[" + operation + "] no such operation.");
        }
    }

    private double addition(double first, double second) {
        if (first == Double.MAX_VALUE || second == Double.MAX_VALUE) {
            throw new ArithmeticException("Value is too big.");
        }
        return first + second;
    }

    private double subtraction(double first, double second) {
        if (first == Double.MIN_VALUE && second > 0) {
            throw new ArithmeticException("Value is too small.");
        }
        return first - second;
    }

    private double multiplication(double first, double second) {
        int isTooBigValue = BigDecimal.valueOf(first)
                .multiply(BigDecimal.valueOf(second))
                .compareTo(BigDecimal.valueOf(Double.MAX_VALUE));
        if (first == Double.MAX_VALUE
                || second == Double.MAX_VALUE
                || isTooBigValue > 0) {
            throw new ArithmeticException("Value is to big.");
        }
        return first * second;
    }

    private double division(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Division by zero.");
        }
        return first / second;
    }

    private double pow(double first, double pow) {
        return Math.pow(first, pow);
    }
}
