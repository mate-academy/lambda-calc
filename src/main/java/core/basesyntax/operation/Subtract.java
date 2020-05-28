package core.basesyntax.operation;

public class Subtract implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
