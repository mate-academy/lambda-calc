package core.basesyntax;

import java.util.function.BinaryOperator;

public class Calculator {
    public static long calculate(long first, long second, char operation) {
        BinaryOperator<Long> calculator =
                operation == '*' ? (a, b) -> a * b
                        : operation == '/' ? (a, b) -> a / b
                        : operation == '-' ? (a, b) -> a - b
                        : operation == '+' ? Long::sum
                        : operation == '^' ? (a, b) -> (long) Math.pow(a, b)
                        : (a, b) -> {
            throw new IllegalArgumentException("Wrong operation!");
        };
        return calculator.apply(first, second);
    }
}
