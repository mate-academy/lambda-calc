package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculete(double first, double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new ArithmeticException();
        }
        DoubleBinaryOperator operator =
                operation == '+' ? (a, b) -> a + b :
                operation == '-' ? (a, b) -> a - b :
                operation == '/' ? (a, b) -> a / b :
                operation == '*' ? (a, b) -> a * b :
                operation == 'p' ? (a, b) -> Math.pow(a, b) :
                        (a, b) -> {
                            throw new NullPointerException();
                        };
        return operator.applyAsDouble(first, second);
    }
}
