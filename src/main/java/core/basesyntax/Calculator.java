package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator implements Calculable {

    @Override
    public double calculate(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return (double) operand1 + (double) operand2;
            case '-':
                return (double) operand1 - (double) operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (double) operand1 / (double) operand2;
            case '*':
                return (double) operand1 * (double) operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new RuntimeException("ERROR impossible operand detected: " + operator);
        }
    }
}
