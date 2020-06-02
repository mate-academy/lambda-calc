package core.basesyntax;

import java.util.function.BinaryOperator;

public class Calculator {
    public static double evaluate(double var1, double var2, char c) {
        BinaryOperator<Double> calculator =
                c == '+' ? (a, b) -> a + b
                        : c == '-' ? (a, b) -> a - b
                        : c == '*' ? (a, b) -> a * b
                        : c == '/' ? (a, b) -> a / b
                        : c == '^' ? Math::pow
                        : (a, b) -> {
                            throw new RuntimeException("Error");
                        };
        return calculator.apply(var1, var2);
    }
}
