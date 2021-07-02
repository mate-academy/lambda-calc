package core.basesyntax;

public class LambdaCalc {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static final char RAISING = '^';

    public double calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case ADDITION:
                return operand1 + operand2;
            case SUBTRACTION:
                return operand1 - operand2;
            case MULTIPLICATION:
                return operand1 * operand2;
            case DIVISION:
                if (operand2 == 0 || operand2 == -0) {
                    throw new ArithmeticException("Division by zero result cannot be provided");
                }
                return operand1 / operand2;
            case RAISING:
                if ((operand1 == 0 || operand1 == -0) && operand2 < 0) {
                    throw new ArithmeticException("Zero in negative pow cannot be provided");
                }
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Operation type not supported");
        }
    }
}
