package core.basesyntax;

public class Subtraction implements Action {
    @Override
    public double doAction(double a, double b) {
        return a - b;
    }
}
