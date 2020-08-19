package core.basesyntax;

public class Addition implements Action {
    @Override
    public double doAction(double a, double b) {
        return a + b;
    }
}
