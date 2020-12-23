package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class SimpleCalculator implements Calculator {
    private static final Map<Character, Operation> operations = new HashMap<>();

    @Override
    public double calculate(double first, double second, char operation) {
        init();
        Operation op = operations.get(operation);
        if (op == null) {
            throw new NoSuchOperationException();
        }
        return op.operation(first, second);
    }

    private void init() {
        SimpleCalculator.operations.put(Operation.ADDITION.getOperation(), Operation.ADDITION);
        SimpleCalculator.operations.put(Operation.SUBTRACTION.getOperation(), Operation.SUBTRACTION);
        SimpleCalculator.operations.put(Operation.DIVISION.getOperation(), Operation.DIVISION);
        SimpleCalculator.operations.put(Operation.MULTIPLICATION.getOperation(), Operation.MULTIPLICATION);
        SimpleCalculator.operations.put(Operation.POWER.getOperation(), Operation.POWER);
    }
}
