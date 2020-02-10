package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculate(double first, double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new ArithmeticException("We can't divide on 0");
        }
        if (second < 0 && operation == '^') {
            throw new ArithmeticException("We can't get power from negative index");
        }
        DoubleBinaryOperator operator =
                operation == '+' ? (a, b) -> a + b :
                        operation == '-' ? (a, b) -> a - b :
                                operation == '/' ? (a, b) -> a / b :
                                        operation == '*' ? (a, b) -> a * b :
                                                operation == '^' ? (a, b) -> Math.pow(a, b) : null;
        return operator.applyAsDouble(first, second);
    }
}
