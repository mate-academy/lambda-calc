package core.basesyntax;

public class AddOperation implements ArithmeticOperation {

    @Override
    public double action(double a, double b) {
        return a + b;
    }
}
