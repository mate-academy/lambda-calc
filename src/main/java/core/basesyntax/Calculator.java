package core.basesyntax;

class Calculator {
    private static final String DIVISION_BY_ZERO_MESSAGE = "Division by zero.";

    public double calculate(double first, double second, char operation) {
        if (operation == '+') {
            return first + second;
        }
        if (operation == '-') {
            return first - second;
        }
        if (operation == '/') {
            if (second == 0) {
                throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
            }
            return first / second;
        }
        if (operation == '*') {
            return first * second;
        }
        if (operation == '^') {
            return Math.pow(first, second);
        }
        if (operation == '%') {
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
