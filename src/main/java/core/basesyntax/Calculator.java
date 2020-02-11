package core.basesyntax;

import java.security.InvalidParameterException;
import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public Double calculate(double num1, double num2, char signifier) {
        if (num2 == 0 && signifier == '/') {
            throw new ArithmeticException();
        }
        DoubleBinaryOperator result = signifier == '+' ? (a, b) -> a + b
                : signifier == '-' ? (a, b) -> a - b
                : signifier == '*' ? (a, b) -> a * b
                : signifier == '/' ? (a, b) -> a / b
                : signifier == '^' ? (a, b) -> Math.pow(a, b)
                : (a, b) -> {
                    throw new InvalidParameterException();
                };

        return result.applyAsDouble(num1, num2);
    }
}
