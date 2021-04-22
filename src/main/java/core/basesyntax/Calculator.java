package core.basesyntax;

public class Calculator implements Calculate {
    @Override
    public double calculate(double value1, double value2, char operation) {
        switch (operation) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                if (value2 == 0) {
                    throw new ArithmeticException("Can't divide by zero.");
                }
                return value1 / value2;
            case '^':
                return Math.pow(value1, value2);
            default:
                throw new IllegalArgumentException("Inappropriate operation " + operation);
        }
    }
}
