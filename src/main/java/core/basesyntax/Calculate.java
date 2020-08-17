package core.basesyntax;

import java.util.function.BinaryOperator;

public class Calculate {

    public double getResult(double x, double y, char operation) {
        if (y == 0 && operation == '/') {
            throw new ArithmeticException("Can't division by zero!");
        }
        return operation == '+' ? sum(x, y)
                : operation == '-' ? sub(x, y)
                : operation == '*' ? mult(x, y)
                : operation == '/' ? div(x, y)
                : operation == '^' ? expon(x, y)
                : null;
    }

    private double sum(double x, double y) {
        BinaryOperator<Double> op1 = (a, b) -> a + b;
        return op1.apply(x, y);
    }

    private double sub(double x, double y) {
        BinaryOperator<Double> op1 = (a, b) -> a - b;
        return op1.apply(x, y);
    }

    private double div(double x, double y) {
        BinaryOperator<Double> op1 = (a, b) -> a / b;
        return op1.apply(x, y);
    }

    private double mult(double x, double y) {
        BinaryOperator<Double> op1 = (a, b) -> a * b;
        return op1.apply(x, y);
    }

    private double expon(double x, double y) {
        BinaryOperator<Double> op1 = (a, b) -> Math.pow(a, b);
        return op1.apply(x, y);
    }
}
