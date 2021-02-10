package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static Double calculate(double first, double second, char operation) {
        if (operation == '/' && second == 0) {
            throw new IllegalArgumentException("Using dividing by zero is forbidden!");
        }
        DoubleBinaryOperator operator = operation == '+' ? (a, b) -> a + b
                : operation == '-' ? (a, b) -> a - b
                : operation == '*' ? (a, b) -> a * b
                : operation == '/' ? (a, b) -> a / b
                : operation == '^' ? Math::pow
                : (a, b) -> {
                    throw new IllegalArgumentException(
                    "Use only +, -, *, /, ^ operators, but not " + operation);
                };
        return operator.applyAsDouble(first, second);
    }

    public static void main(String[] args) {
        System.out.println(calculate(10d, 20d, '+'));
        System.out.println(calculate(10d, 20d, '-'));
        System.out.println(calculate(10d, 20d, '*'));
        System.out.println(calculate(10d, 20d, '/'));
        System.out.println(calculate(10d, 2d, '^'));
    }
}
