package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final String REGEX_NUMBERS = " \\S ";
    private static final String REGEX_OPERANDS = "(.\\d|\\d|\\s)";
    private ArithmeticOperation lastOperation;
    private Map<String, ArithmeticOperation> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put("+", new AddOperation());
        operations.put("-", new SubtrOperation());
        operations.put("^", new PowOperation());
        operations.put("/", new DivOperation());
        operations.put("*", new MultOperation());
    }

    public ArithmeticOperation getLastOperation() {
        return lastOperation;
    }

    public double calculate(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is empty!");
        }
        lastOperation = getOperation(str);
        double[] numbers = getNumbers(str);
        return lastOperation.action(numbers[0], numbers[1]);
    }

    private double[] getNumbers(String str) {
        String[] numbers = str.split(REGEX_NUMBERS);
        return new double[]{Double.valueOf(numbers[0]), Double.valueOf(numbers[1])};
    }

    private ArithmeticOperation getOperation(String str) {
        ArithmeticOperation operation = operations.get(str.replaceAll(REGEX_OPERANDS, ""));
        if (operation == null) {
            throw new IllegalArgumentException("The required parameter is missing!");
        }
        return operation;
    }
}
