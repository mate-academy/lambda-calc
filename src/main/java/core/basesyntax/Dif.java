package core.basesyntax;

public class Dif implements BinaryOperator {
    @Override
    public Double result(double a, double b) {
        return a - b;
    }
}
