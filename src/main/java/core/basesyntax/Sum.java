package core.basesyntax;

public class Sum implements BinaryOperator {
    @Override
    public Double result(double a, double b) {
        return a + b;
    }
}
