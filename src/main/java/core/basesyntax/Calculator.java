package core.basesyntax;

import exceptions.IllegalOperationException;

public class Calculator {

    public double calculate(double a, double b, Character operation)
            throws IllegalOperationException {
        switch (operation) {
            case ('+') :
                return a + b;
            case ('-') :
                return a - b;
            case ('*') :
                return a * b;
            case ('/') :
                if (b == 0) {
                    throw new ArithmeticException("Dividing zero!");
                }
                return a / b;
            case ('^') :
                return Math.pow(a, b);
            default:
                throw new IllegalOperationException("Illegal operation!");
        }
    }
}
