package core.basesyntax;

public class Calculator {
    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return firstNumber / secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new RuntimeException("Operation is incorrect: " + operation);
        }
    }
}
