package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(double firstValue, double secondValue, char operation) {
        if (Character.toString(operation).matches("[^\\+\\-\\*\\/\\^]")) {
            throw new IllegalOperation();
        }
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                if (secondValue == 0.0) {
                    throw new DivisionByZero();
                }
                return firstValue / secondValue;
            case '^':
                if (firstValue < 0
                        && secondValue != 0.0
                        && secondValue < 1
                        && secondValue > -1) {
                    throw new IllegalValues();
                }
                return Math.pow(firstValue, secondValue);
            default:
                return 0.0;
        }
    }
}
