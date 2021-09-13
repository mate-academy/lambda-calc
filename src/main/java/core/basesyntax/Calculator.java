package core.basesyntax;

public class Calculator {
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
                    throw new ArithmeticException("can`t divide on 0");
                }
                return firstValue / secondValue;
            case '^':
                if (secondValue == Double.MIN_VALUE) {
                    throw new IllegalValueException("can`t resolve operation");
                }
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalOperatorException("can't recognise operator, try again");
        }
    }
}
