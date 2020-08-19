package core.basesyntax;

public class Division implements Action {
    @Override
    public double doAction(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Dividing by zero is not allowed!");
        }
        return a / b;
    }
}
