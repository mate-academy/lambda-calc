package core.basesyntax;

import core.basesyntax.operation.Division;
import core.basesyntax.operation.Exponent;
import core.basesyntax.operation.Multiplication;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.Subtract;
import core.basesyntax.operation.Sum;
import java.util.HashMap;

public class Calculator {
    private static final HashMap<Character, Operation> OPERATIONS;

    static {
        OPERATIONS = new HashMap<>();
        OPERATIONS.put('+', new Sum());
        OPERATIONS.put('-', new Subtract());
        OPERATIONS.put('*', new Multiplication());
        OPERATIONS.put('/', new Division());
        OPERATIONS.put('^', new Exponent());
    }

    public double calculate(double a, double b, char operator) {
        return OPERATIONS.get(operator).calculate(a, b);
    }
}
