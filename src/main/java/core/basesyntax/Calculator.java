package core.basesyntax;

import core.basesyntax.exceptions.OperatorException;
import core.basesyntax.exceptions.ValueException;

public class Calculator implements Calculating {

    @Override
    public double calculate(double a, double b, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0.00) {
                    throw new ValueException("Division by zero");
                }
                result = a / b;
                break;
            case '^':
                if (a == 0 && b < 0) {
                    throw new ValueException("Zero cannot powered to negative value");
                }
                result = Math.pow(a, b);
                break;
            default:
                throw new OperatorException("Wrong operator");
        }
        return result;
    }
}
