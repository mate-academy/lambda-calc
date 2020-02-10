package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static Double calculate(double first, double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new IllegalArgumentException("Division by zero is not possible");
        }
        DoubleBinaryOperator result =  operation == '+' ? (a, b) -> a + b
                : operation == '-' ? (a, b) -> a - b
                : operation == '*' ? (a, b) -> a * b
                : operation == '/' ? (a, b) -> a / b
                : operation == '^' ? Math::pow
                : (a, b) -> {
                    throw new IllegalArgumentException(
                    "Use only +, -, *, /, ^ operators, but not " + operation);
                };
        return result.applyAsDouble(first, second);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.calculate(3.0, 2.0, '+'));
        System.out.println(Calculator.calculate(3.0, 2.0, '-'));
        System.out.println(Calculator.calculate(3.0, 2.0, '*'));
        System.out.println(Calculator.calculate(3.0, 2.0, '/'));
        System.out.println(Calculator.calculate(3.0, 2.0, '^'));
    }
}
