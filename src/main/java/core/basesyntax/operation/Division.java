package core.basesyntax.operation;

public class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Can't division by zero!");
        }
        return a / b;
    }
}
