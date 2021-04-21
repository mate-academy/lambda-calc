package core.basesyntax;

public class Calculator {

    public double calculate(double firstNumber, double secondNumber, char operation) {
        if (operation == '^') {
            return Math.pow(firstNumber, secondNumber);
        }
        if (operation == '+') {
            return firstNumber + secondNumber;
        }
        if (operation == '-') {
            return firstNumber - secondNumber;
        }
        if (operation == '*') {
            return firstNumber * secondNumber;
        }
        if (operation == '/') {
            if (secondNumber == 0) {
                throw new ArithmeticException("You can`t divide by zero");
            }
            return firstNumber / secondNumber;
        }
        throw new RuntimeException("Invalid operation" + operation);
    }
}
