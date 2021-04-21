package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, char operationType) {
        if (operationType == '+') {
            return firstValue + secondValue;
        }
        if (operationType == '-') {
            return firstValue - secondValue;
        }
        if (operationType == '/') {
            if (secondValue == 0) {
                throw new ArithmeticException("Impossible to divide on zero");
            }
            return firstValue / secondValue;
        }
        if (operationType == '*') {
            return firstValue * secondValue;
        }
        if (operationType == '^') {
            return Math.pow(firstValue, secondValue);
        }
        throw new RuntimeException("Wrong operation type: " + operationType);
    }
}
