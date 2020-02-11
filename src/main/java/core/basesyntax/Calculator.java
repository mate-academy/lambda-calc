package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double first, double second, double operation) {
        DoubleBinaryOperator doubleBinaryOperator = operation == '+' ? (f, s) -> f + s
                : operation == '-' ? (f, s) -> f - s
                : operation == '*' ? (f, s) -> f * s
                : operation == '/' ? (f, s) -> f / s
                : operation == '^' ? (f, s) -> Math.pow(f, s)
                : (f, s) -> {
                    throw new IllegalArgumentException("Invalid operation mark. Use only +, -, *, "
                    + "/, ^");
                };
        return doubleBinaryOperator.applyAsDouble(first, second);
    }
}
