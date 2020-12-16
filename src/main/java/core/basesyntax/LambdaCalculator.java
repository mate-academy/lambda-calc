package core.basesyntax;

public class LambdaCalculator {
    public double calculate(int firstValue, int secondValue, char operation) {
        if (operation == '+') {
            return firstValue + secondValue;
        }
        if (operation == '-') {
            return firstValue - secondValue;
        }
        if (operation == '*') {
            return firstValue * secondValue;
        }
        if (operation == '/') {
            if (secondValue == 0) {
                throw new ArithmeticException("We cant divide by 0");
            }
            return (double) firstValue / secondValue;
        }
        if (operation == '^') {
            return Math.pow(firstValue, secondValue);
        }
        throw new IllegalArgumentException("Bad operation symbol!");
    }
}
