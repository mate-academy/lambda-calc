package core.basesyntax;

public class Div implements BinaryOperator {
    @Override
    public Double result(double a, double b) {
        return a / b;
    }
}
