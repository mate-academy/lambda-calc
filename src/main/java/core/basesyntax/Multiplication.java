package core.basesyntax;

public class Multiplication implements Action {
    @Override
    public double doAction(double a, double b) {
        return a * b;
    }
}
