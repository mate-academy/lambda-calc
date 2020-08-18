package core.basesyntax.functions;

import core.basesyntax.Calculable;

public class Raise implements Calculable {
    public static final Character OPERATION = '^';

    @Override
    public double calculate(double first, double second) {
        return Math.pow(first,second);
    }
}
