package core.basesyntax;

public class Calculator {

    public double calculate(Double first, Double second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if (second == 0) {
                    throw new ArithmeticException();
                }
                return first / second;
            case '^':
                return Math.pow(first, second);
            default:
                throw new RuntimeException("No such operator:" + operator);
        }
    }
}
