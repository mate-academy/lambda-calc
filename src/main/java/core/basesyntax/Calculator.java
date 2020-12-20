package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator implements Calculable {

    @Override
    public int calculate(int operand1, int operand2, char operator) {
        long result;
        switch (operator) {
            case '+':
                result = (long) operand1 + (long) operand2;
                checkIfInBounds(result);
                return (int) result;
            case '-':
                result = (long) operand1 - (long) operand2;
                checkIfInBounds(result);
                return (int) result;
            case '/':
                return operand1 / operand2;
            case '*':
                result = (long) operand1 * (long) operand2;
                checkIfInBounds(result);
                return (int) result;
            case '^':
                double doubleResult = Math.pow(operand1, operand2);
                checkIfInBounds(doubleResult);
                return (int) doubleResult;
            default:
                throw new RuntimeException("ERROR impossible operand detected: " + operator);
        }
    }

    private void checkIfInBounds(long value) {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result is out of integer capacity");
        }
    }

    private void checkIfInBounds(double value) {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result is out of integer capacity");
        }
    }
}
