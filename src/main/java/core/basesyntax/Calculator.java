package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(Double first, Double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new ArithmeticException("Cannot be divided by zero!");
        }
        DoubleBinaryOperator operator
                = operation == '+' ? Double::sum
                : operation == '-' ? (x, y) -> x - y
                : operation == '/' ? (x, y) -> x / y
                : operation == '*' ? (x, y) -> x * y
                : operation == '^' ? Math::pow
                : (x, y) -> {
                    throw new IllegalArgumentException("Operation is not supported!");
                };
        return operator.applyAsDouble(first, second);
    }
}
