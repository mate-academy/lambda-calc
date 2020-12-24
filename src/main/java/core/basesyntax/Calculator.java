package core.basesyntax;

public class Calculator {
    public double calculate(double first, double second, char operator) {
        switch (operator) {
            case '+': {
                return first + second;
            }
            case '-': {
                return first - second;
            }
            case '*': {
                return first * second;
            }
            case '/': {
                if (second == 0) {
                    throw new ArithmeticException();
                }
                return first / second;
            }
            case '^': {
                return Math.pow(first, second);
            }
            default:
                throw new UnsupportedOperationException("Use + for additional \n"
                        + "Use - for subtraction \n"
                        + "Use * for multiplication \n"
                        + "Use / for division \n"
                        + "Use ^ for raise to power");
        }
    }
}
