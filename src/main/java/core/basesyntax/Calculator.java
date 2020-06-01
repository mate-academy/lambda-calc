package core.basesyntax;

import java.util.function.DoubleBinaryOperator;

public class Calculator {
    private final DoubleBinaryOperator[] doubleBinaryOperators = new DoubleBinaryOperator[5];
    private final String operations;

    public Calculator() {
        operations = "+-*/^";
        doubleBinaryOperators[0] = Double::sum;
        doubleBinaryOperators[1] = (x, y) -> x - y;
        doubleBinaryOperators[2] = (x, y) -> x * y;
        doubleBinaryOperators[3] = (x, y) -> x / y;
        doubleBinaryOperators[4] = Math::pow;
    }

    public double calculate(double a, double b, char operation) {
        int position = operations.indexOf(operation);
        try {
            double result = doubleBinaryOperators[position].applyAsDouble(a, b);
            if (Double.isInfinite(result)) {
                throw new ArithmeticException("Forbidden operation: " + a + operation + b);
            }
            return result;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Unexpected operation: ( " + operation + " )", e);
        }
    }
}
