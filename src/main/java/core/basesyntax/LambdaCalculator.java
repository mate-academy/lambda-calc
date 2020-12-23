package core.basesyntax;

public class LambdaCalculator {
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("We cant divide by 0");
                }
                return firstValue / secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("Bad operation symbol!");
        }
    }
}

