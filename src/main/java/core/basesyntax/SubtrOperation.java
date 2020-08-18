package core.basesyntax;

public class SubtrOperation implements ArithmeticOperation {

    @Override
    public double action(double a, double b) {
        return a - b;
    }
}
