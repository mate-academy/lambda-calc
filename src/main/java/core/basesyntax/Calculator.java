package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double a, double b, char operation) {
        DoubleBinaryOperator result = (operation == '+') ? (x, y) -> x + y
                : (operation == '-') ? (x, y) -> x - y
                : (operation == '*') ? (x, y) -> x * y
                : (operation == '/') ? (x, y) -> x / y
                : (operation == '^') ? (x, y) -> Math.pow(x, y)
                : (x, y) -> {
                    throw new IllegalArgumentException("No such operation. Use +, -, /, *, ^");
                };
        return result.applyAsDouble(a, b);
    }
}
