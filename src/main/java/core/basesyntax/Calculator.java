package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(double firstVariable, double secondValue, char operation) {
        if (Character.toString(operation).matches("[^\\+\\-\\*\\/\\^]")) {
            throw new IllegalOperation();
        }
        switch (operation) {
            case '+':
                return firstVariable + secondValue;
            case '-':
                return firstVariable - secondValue;
            case '*':
                return firstVariable * secondValue;
            case '/':
                if (secondValue == 0.0) {
                    throw new DivisionByZero();
                }
                return firstVariable / secondValue;
            case '^':
                return Math.pow(firstVariable, secondValue);
            default:
                return 0.0;
        }
    }
}
