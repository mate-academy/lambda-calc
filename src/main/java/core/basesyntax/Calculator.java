package core.basesyntax;

public class Calculator {
    public double calculate(double firstNumber, char operation, double secondNumber) {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new ArithmeticException("Invalid math operator");
        }
    }
}
