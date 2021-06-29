package core.basesyntax;

class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POW = '^';
    private static final char REMAINDER_DIVISION = '%';
    private static final String DIVISION_BY_ZERO_MESSAGE = "Division by zero.";

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case ADDITION:
                return first + second;
            case SUBTRACTION:
                return first - second;
            case DIVISION:
                if (second == 0) {
                    throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
                }
                return first / second;
            case MULTIPLICATION:
                return first * second; 
            case POW:
                return Math.pow(first, second);
            case REMAINDER_DIVISION:
                if (second == 0) {
                    throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
                }
                if (first % second == -0) {
                    return 0;
                }
                return first % second;
            default:
                throw new InvalidOperatorException("There is no arithmetic operator like this");
        }
    }
}
