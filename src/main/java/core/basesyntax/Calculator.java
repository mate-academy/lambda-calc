package core.basesyntax;

import core.basesyntax.exception.DivisionByZeroException;
import core.basesyntax.exception.NotSupportOperationException;

public class Calculator {
    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case '+' :
                return first + second;
            case '-' :
                return first - second;
            case '/' :
                if (second == 0) {
                    throw new DivisionByZeroException("Not support division by zero!");
                }
                return first / second;
            case '*' :
                return first * second;
            case '^' :
                return Math.pow(first, second);
            default:
                throw new NotSupportOperationException("This operation '"
                    + operation + "' not supports!");
        }
    }
}
