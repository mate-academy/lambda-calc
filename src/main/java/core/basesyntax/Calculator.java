package core.basesyntax;

public class Calculator {

    public double calculate(Double firstValue, Double secondValue, char operator) {
        switch (operator) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                if (secondValue == 0) {
                    throw new ArithmeticException("Can't be divided by zero");
                }
                return firstValue / secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new RuntimeException("No such operator:" + operator);
        }
    }
}
