package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public static Map<Character, BinaryOperator> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put('+', new Sum());
        operations.put('-', new Dif());
        operations.put('*', new Mult());
        operations.put('/', new Div());
        operations.put('^', new Pow());
    }

    public Double calculation(double a, double b, char operation) {
        BinaryOperator operator = operations.get(operation);
        if (operator == null) {
            throw new ArithmeticException(
                    "Wrong operator provided, can't execute current operation");
        }
        return operator.result(a, b);
    }
}
