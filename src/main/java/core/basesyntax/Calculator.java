package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(Double first, Double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new ArithmeticException("");
        }
        DoubleBinaryOperator operator
                = operation == '+' ? Double::sum
                : operation == '-' ? (x, y) -> x - y
                : operation == '/' ? (x, y) -> x / y
                : operation == '*' ? (x, y) -> x * y
                : operation == '^' ? Math::pow
                : (x, y) -> {
                    throw new IllegalArgumentException();
                };
        return operator.applyAsDouble(first, second);
    }
}
