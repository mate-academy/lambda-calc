package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculate {

    public double calculate(double first, double second, char operation) {
        if (second == 0 && operation == '/') {
            throw new ArithmeticException("Division by zero");
        }
        DoubleBinaryOperator operator =
                operation == '/' ? (a, b) -> a / b :
                operation == '*' ? (a, b) -> a * b :
                operation == '+' ? (a, b) -> a + b :
                operation == '-' ? (a, b) -> a - b :
                        (a, b) -> {
                            throw new NullPointerException();
                        };
        return operator.applyAsDouble(first, second);
    }
}
