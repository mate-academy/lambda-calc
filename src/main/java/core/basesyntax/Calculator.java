package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public static Double calculate(double num1, double num2, Character operator) {
        if (num2 == 0 && operator == '/') {
            throw new IllegalArgumentException("Division by 0 is not possible");
        }
        DoubleBinaryOperator result =
                operator == '+' ? Double::sum
                        : operator == '-' ? (a, b) -> a - b
                        : operator == '*' ? (a, b) -> a * b
                        : operator == '/' ? (a, b) -> a / b
                        : operator == '^' ? Math::pow
                        : (a, b) -> {
                            throw new IllegalArgumentException(
                                    "Illegal operator, use only + - / * ^ as operator");
                        };
        return result.applyAsDouble(num1, num2);
    }
}
