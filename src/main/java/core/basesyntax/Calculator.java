package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public double calculate(double x, double y, char o) {
        Map<Character, MathOperation> mathOperationMap = new HashMap<>();
        mathOperationMap.put('+', Double::sum);
        mathOperationMap.put('-', (x1, y1) -> x1 - y1);
        mathOperationMap.put('*', (x1, y1) -> x1 * y1);
        mathOperationMap.put('/', (x1, y1) -> x1 / y1);
        mathOperationMap.put('^', Math::pow);
        MathOperation mathOperation = mathOperationMap.get(o);
        if (mathOperation == null) {
            throw new IllegalArgumentException();
        }
        return mathOperation.calculate(x, y);
    }
}
