package core.basesyntax;

public class Calculator {

    public double calculate(double firstValue, double secondValue, char operator) {
        switch (operator) {
            case '+':
                return add(firstValue, secondValue);
            case '-':
                return subtract(firstValue, secondValue);
            case '*':
                return multiply(firstValue, secondValue);
            case '/':
                return divide(firstValue, secondValue);
            case '^':
                return pow(firstValue, secondValue);
            default:
                throw new RuntimeException("No such operation exception: " + operator);
        }
    }

    private double add(double firstValue, double secondValue) {
        if (Double.MAX_VALUE - firstValue < secondValue) {
            throw new RuntimeException("Double overflow");
        }
        return firstValue + secondValue;
    }

    private double subtract(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }

    private double multiply(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    private double divide(double firstValue, double secondValue) {
        if (secondValue == 0) {
            throw new ArithmeticException("Division  secondValue by 0");
        }
        return firstValue / secondValue;
    }

    private double pow(double firstValue, double secondValue) {
        return Math.pow(firstValue, secondValue);
    }

}
