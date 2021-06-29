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
        if (operation == ADDITION) {
            return first + second;
        }
        if (operation == SUBTRACTION) {
            return first - second;
        }
        if (operation == DIVISION) {
            if (second == 0) {
                throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
            }
            return first / second;
        }
        if (operation == MULTIPLICATION) {
            return first * second;
        }
        if (operation == POW) {
            return Math.pow(first, second);
        }
        if (operation == REMAINDER_DIVISION) {
            if (second == 0) {
                throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
            }
            if (first % second == -0) {
                return 0;
            }
            return first % second;
        }
        throw new InvalidOperatorException();
    }
}
