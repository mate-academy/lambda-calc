package core.basesyntax;

public class Calculator {

    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new RuntimeException("Error, division by 0");
                }
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                if (firstValue < 0 && secondValue != (long) secondValue) {
                    throw new RuntimeException("Error");
                }
                return Math.pow(firstValue, secondValue);
            default:
                throw new RuntimeException("Error, unknown operation type");
        }
    }
}
