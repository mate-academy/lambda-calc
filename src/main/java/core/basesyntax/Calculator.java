package core.basesyntax;

public class Calculator {
    private char operation;
    private double firstNumber;
    private double secondNumber;

    public Calculator(char operation, double firstNumber, double secondNumber) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double result() {
        switch (operation) {
            case ('+'):
                return firstNumber + secondNumber;
            case ('-'):
                return firstNumber - secondNumber;
            case ('*'):
                return firstNumber * secondNumber;
            case ('/'):
                if (secondNumber == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                return firstNumber / secondNumber;
            case ('^'):
                return Math.pow(firstNumber, secondNumber);
            default:
                return Double.parseDouble(null);
        }
    }
}
