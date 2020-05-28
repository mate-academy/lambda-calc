package core.basesyntax.operation;

public class Exponent implements Operation {
    @Override
    public double calculate(double a, double b) {
        return Math.pow(a, b);
    }
}
