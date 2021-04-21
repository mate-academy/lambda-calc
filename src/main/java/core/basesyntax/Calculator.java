package core.basesyntax;

public class Calculator implements Calculate {
    public double calculate(double first, double second, char character) {
        switch (character) {
            case '/': case ':':
                if (first == 0) {
                    return 0;
                }
                if (second == 0) {
                    throw new ArithmeticException("Divisor " + second + " is not allowed");
                }
                return first / second;
            case '*':
                return first * second;
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '^':
                return Math.pow(first, second);
            default:
                throw new RuntimeException("There is no such operation: " + character);
        }
    }
}
