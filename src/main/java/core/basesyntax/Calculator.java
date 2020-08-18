package core.basesyntax;

public class Calculator {

    public double calculate(double firstNumber, char mathAction, double secondNumber)
            throws NoSuchOperationException {
        exceptionsCheck(mathAction, secondNumber);
        switch (mathAction) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                return 0;
        }
    }

    public void exceptionsCheck(char mathAction, double secondNumber)
            throws NoSuchOperationException {
        if (mathAction == '/' && secondNumber == 0) {
            throw new ArithmeticException("Division by zero is impossible");
        } else if (mathAction != '*'
                && mathAction != '/'
                && mathAction != '+'
                && mathAction != '^'
                && mathAction != '-') {
            throw new NoSuchOperationException("Not correct action. Choose from: +, -, *, / or ^");
        }
    }

    class NoSuchOperationException extends RuntimeException {
        public NoSuchOperationException(String message) {
            super(message);
        }
    }
}

