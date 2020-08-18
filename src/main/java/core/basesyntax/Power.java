package core.basesyntax;

public class Power implements Action {
    @Override
    public double doAction(double a, double b) {
        return Math.pow(a, b);
    }
}
