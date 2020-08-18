package core.basesyntax;

public class Calculator {

    public double calculate(double firstValue, double secondValue, char operation) {
        if (secondValue == 0 && operation == '/') {
            throw new ArithmeticException("Division by zero!");
        }
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '/':
                return firstValue / secondValue;
            case '*':
                return firstValue * secondValue;
            case '^':
                return Math.pow(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("No valid operation!");
        }
    }
}



