package core.basesyntax.functions;

import core.basesyntax.Calculable;

public class Substract implements Calculable {
    public static final Character OPERATION = '-';

    @Override
    public double calculate(double firstArgument, double secondArgument) {
        return firstArgument - secondArgument;
    }
}
