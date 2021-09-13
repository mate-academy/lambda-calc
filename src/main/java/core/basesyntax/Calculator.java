package core.basesyntax;

public class Calculator {
    public double calculate(double firstValue, double secondValue, char operation) {
        if (firstValue == Double.MAX_VALUE && secondValue > 0
                || secondValue == Double.MAX_VALUE && firstValue > 0) {
            throw new ArithmeticException("Double max value error");
        }
        double result;
        switch (operation) {
            case '+':
                result = firstValue + secondValue;
                break;

            case '-':
                result = firstValue - secondValue;
                break;

            case '*':
                result = firstValue * secondValue;
                break;

            case '/':
                if (secondValue == 0.0
                        || secondValue == Double.MIN_VALUE) {
                    throw new ArithmeticException("Division by zero");
                }
                result = firstValue / secondValue;
                break;

            case '^':
                result = Math.pow(firstValue, secondValue);
                break;

            default:
                throw new RuntimeException("Illegal operation: " + operation);
        }
        return result;
    }
}

