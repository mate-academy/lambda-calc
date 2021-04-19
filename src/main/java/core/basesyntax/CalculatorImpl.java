package core.basesyntax;

public class CalculatorImpl implements Calculator {
    public double calculate(double firstNumber, double secondNumber, char operation) {
        if (operation == '+') {
            return firstNumber + secondNumber;
        }
        if (operation == '-') {
            return firstNumber - secondNumber;
        }
        if (operation == '/') {
            if (secondNumber == 0) {
                throw new ArithmeticException("Division by zero is impossible!");
            }
            return firstNumber / secondNumber;
        }
        if (operation == '*') {
            return firstNumber * secondNumber;
        }
        if (operation == '^') {
            return Math.pow(firstNumber, secondNumber);
        }
        throw new RuntimeException("Unsupported operation: " + operation);
    }
}
