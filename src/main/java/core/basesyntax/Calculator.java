package core.basesyntax;

public class Calculator {
    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("You can't divide by 0!");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("This operation " + operation
                        + " doesn't exist");
        }
    }
}
