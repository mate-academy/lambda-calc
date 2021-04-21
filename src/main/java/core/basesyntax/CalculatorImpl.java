package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private static final String ARITHMETIC_MESSAGE = "Can`t divide by Zero!";
    private static final String BAD_OPERAND_MESSAGE = "Invalid type of operand";

    @Override
    public double calculate(double a, double b, char operand) {
        switch (operand) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException(ARITHMETIC_MESSAGE);
                }
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException(BAD_OPERAND_MESSAGE);
        }
    }
}
