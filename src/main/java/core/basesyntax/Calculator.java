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

    private final Map<Character, Calculable> calculatorsFunctions;

    public Calculator() {
        this.calculatorsFunctions = new HashMap<>();
        calculatorsFunctions.put(Substract.OPERATION, new Substract());
        calculatorsFunctions.put(Add.OPERATION, new Add());
        calculatorsFunctions.put(Divide.OPERATION, new Divide());
        calculatorsFunctions.put(Multiply.OPERATION, new Multiply());
        calculatorsFunctions.put(Raise.OPERATION, new Raise());
    }

    public double calculate(double firstArg, double secondArg, Character operation) {
        if (!calculatorsFunctions.containsKey(operation)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return calculatorsFunctions.get(operation).calculate(firstArg, secondArg);
    }
}
