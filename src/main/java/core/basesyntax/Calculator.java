package core.basesyntax;

import core.basesyntax.functions.Add;
import core.basesyntax.functions.Divide;
import core.basesyntax.functions.Multiply;
import core.basesyntax.functions.Raise;
import core.basesyntax.functions.Substract;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public static final String EXCEPTION_MESSAGE = "Can't recognise this operation";

    private final Map<Character, Calculable> functions;

    public Calculator() {
        this.functions = new HashMap<>();
        functions.put(Substract.OPERATION, new Substract());
        functions.put(Add.OPERATION, new Add());
        functions.put(Divide.OPERATION, new Divide());
        functions.put(Multiply.OPERATION, new Multiply());
        functions.put(Raise.OPERATION, new Raise());
    }

    public double calculate(double firstArg, double secondArg, Character operation) {
        if (!functions.containsKey(operation)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return functions.get(operation).calculate(firstArg, secondArg);
    }
}
