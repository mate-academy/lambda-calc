package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    public double calculete(double first, double second, char operation) {
        DoubleBinaryOperator operator =
                operation == '+' ? (a, b) -> a + b :
                operation == '-' ? (a, b) -> a - b :
                operation == '/' ? (a, b) -> a / b :
                operation == '*' ? (a, b) -> a * b :
                operation == 'p' ? (a, b) -> Math.pow(a, b) : null;
        return operator.applyAsDouble(first, second);
    }
}
