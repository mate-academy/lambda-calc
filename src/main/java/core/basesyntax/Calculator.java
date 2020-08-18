package core.basesyntax;

public class Calculator {

    public double calculate(double firstNumber, char mathAction, double secondNumber) {
        switch (mathAction) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (mathAction == '/' && secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is impossible");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new NoSuchOperationException("Not correct action");
        }
    }

    class NoSuchOperationException extends RuntimeException {
        public NoSuchOperationException(String message) {
            super(message);
        }
    }
}
