package core.basesyntax;

import java.math.BigDecimal;

public class Calculator {
    public double calculate(int firstValue, int secondValue, char operator) {
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

    private double add(int firstValue, int secondValue) {
        return (double) firstValue + secondValue;
    }

    private double subtract(int firstValue, int secondValue) {
        return (double) firstValue - secondValue;
    }

    private double multiply(int firstValue, int secondValue) {
        BigDecimal bigDecimal = new BigDecimal(firstValue).multiply(new BigDecimal(secondValue));
        if (bigDecimal.compareTo(new BigDecimal((double) firstValue * secondValue)) == 0) {
            return bigDecimal.doubleValue();
        }
        throw new ArithmeticException("Double overflow");
    }

    private double divide(int firstValue, int secondValue) {
        if (secondValue == 0) {
            throw new ArithmeticException("Division secondValue by 0");
        }
        return (double) firstValue / secondValue;
    }

    private double pow(int firstValue, int secondValue) {
        return Math.pow(firstValue, secondValue);
    }
}
