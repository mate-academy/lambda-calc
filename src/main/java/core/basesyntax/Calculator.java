package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(Double firstValue, char operation, Double secondValue)
            throws UnsupportedOperationException {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                return firstValue / secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
    }
}
