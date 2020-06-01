package core.basesyntax;

public class Pow implements BinaryOperator {
    @Override
    public Double result(double a, double b) {
        return Math.pow(a, b);
    }
}
