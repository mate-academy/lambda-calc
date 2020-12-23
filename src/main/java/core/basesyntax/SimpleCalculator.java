package core.basesyntax;

import static core.basesyntax.Operation.ADDITION;
import static core.basesyntax.Operation.DIVISION;
import static core.basesyntax.Operation.MULTIPLICATION;
import static core.basesyntax.Operation.POWER;
import static core.basesyntax.Operation.SUBTRACTION;

import java.util.HashMap;
import java.util.Map;

public class SimpleCalculator implements Calculator {
    private static final Map<Character, Operation> operations = new HashMap<>();

    @Override
    public double calculate(double first, double second, char operation) {
        init();
        Operation correspondingOperation = operations.get(operation);
        if (correspondingOperation == null) {
            throw new NoSuchOperationException("Please enter the valid operation");
        }
        return correspondingOperation.operation(first, second);
    }

    private void init() {
        SimpleCalculator.operations.put(ADDITION.getOperation(), ADDITION);
        SimpleCalculator.operations.put(SUBTRACTION.getOperation(), SUBTRACTION);
        SimpleCalculator.operations.put(DIVISION.getOperation(), DIVISION);
        SimpleCalculator.operations.put(MULTIPLICATION.getOperation(), MULTIPLICATION);
        SimpleCalculator.operations.put(POWER.getOperation(), POWER);
    }
}
