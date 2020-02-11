package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double a, double b, char c) {
        DoubleBinaryOperator result = (c == '+') ? (x, y) -> x + y
                : (c == '-') ? (x, y) -> x - y
                : (c == '*') ? (x, y) -> x * y
                : (c == '/') ? (x, y) -> x / y
                : (c == '^') ? (x, y) -> Math.pow(x, y)
                : (x, y) -> {
                    throw new IllegalArgumentException("No such operation. Use +, -, /, *, ^");
                };
        return result.applyAsDouble(a, b);
    }
}
