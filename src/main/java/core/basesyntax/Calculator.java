package core.basesyntax;

public class Calculator {

    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Illegal operator passed");
        }
    }
}
