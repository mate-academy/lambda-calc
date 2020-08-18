package core.basesyntax;

import core.basesyntax.exception.DividingByZeroException;

public class Division implements Action {
    @Override
    public double doAction(double a, double b) throws DividingByZeroException {
        if (b == 0) {
            throw new DividingByZeroException("Dividing by zero is not allowed!");
        }
        return a / b;
    }
}
