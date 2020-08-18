package core.basesyntax;

public class PowOperation implements ArithmeticOperation {
    @Override
    public double action(double a, double b) {

        return Math.pow(a, b);
    }
}
