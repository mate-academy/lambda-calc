package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, char operationType) {
        switch (operationType) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("ERROR! --> You can't divide by 0");
                }
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
