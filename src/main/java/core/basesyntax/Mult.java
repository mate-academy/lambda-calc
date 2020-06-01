package core.basesyntax;

public class Mult implements BinaryOperator {
    @Override
    public Double result(double a, double b) {
        return a * b;
    }
}
