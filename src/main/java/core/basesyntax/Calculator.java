package core.basesyntax;

import core.basesyntax.exception.ValidationException;

public class Calculator {
    public double calculate(double a, double b, char operation) throws ValidationException {
        if (operation == '+') {
            return a + b;
        }
        if (operation == '-') {
            return a - b;
        }
        if (b == 0 && operation == '/') {
            throw new ValidationException("Can't divide by zero!");
        }

        if (b != 0 && operation == '/') {
            return a / b;
        }
        if (operation == '*') {
            return a * b;
        }
        if (operation == '^') {
            return Math.pow(a, b);
        }
        return 0;
    }
}
