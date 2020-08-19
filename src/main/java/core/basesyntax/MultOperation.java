package core.basesyntax;

public class MultOperation implements ArithmeticOperation {

    @Override
    public double action(double a, double b) {
        return a * b;
    }
}
