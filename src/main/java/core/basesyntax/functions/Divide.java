package core.basesyntax.functions;

import core.basesyntax.Calculable;

public class Divide implements Calculable {
    public static final Character OPERATION = '/';
    public static final String EXCEPTION_MESSAGE = "Division by zero not allowed!";

    @Override
    public double calculate(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException(EXCEPTION_MESSAGE);
        }
        return first / second;
    }
}
