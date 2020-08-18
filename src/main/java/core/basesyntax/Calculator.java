package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {

    private ArithmeticOperation arithmeticOperation;
    private Map<String, ArithmeticOperation> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put("+", new AddOperation());
        operations.put("-", new SubtrOperation());
        operations.put("^", new PowOperation());
        operations.put("/", new DivOperation());
        operations.put("*", new MultOperation());
    }

    public ArithmeticOperation getArithmeticOperation() {
        return arithmeticOperation;
    }

    public double calculate(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is empty!");
        }
        arithmeticOperation = operationsFactory(str);
        double[] numbers = parserStringArrayToDoubleArray(str);
        return arithmeticOperation.action(numbers[0], numbers[1]);
    }

    private double[] parserStringArrayToDoubleArray(String s) {
        String[] split = s.split("[\\s\\W]+");
        return new double[]{Double.valueOf(split[0]), Double.valueOf(split[1])};
    }

    private ArithmeticOperation operationsFactory(String s) {
        arithmeticOperation = operations.get(s.replaceAll("[\\w\\s]+", ""));
        if (arithmeticOperation == null) {
            throw new IllegalArgumentException("The required parameter is missing!");
        }
        return arithmeticOperation;
    }
}
