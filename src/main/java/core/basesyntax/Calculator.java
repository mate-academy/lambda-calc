package core.basesyntax;

public class Calculator {

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case '^':
                if (firstNumber < 0 && secondNumber - (int) secondNumber != 0) {
                    throw new ArithmeticException("We cannot raise negative number to a fractional power.");
                }
                if (secondNumber < 0) {
                    return 1 / Math.pow(firstNumber, secondNumber * -1);
                }
                return Math.pow(firstNumber, secondNumber);

            case '+':
                return firstNumber + secondNumber;

            case '-':
                return firstNumber - secondNumber;

            case '*':
                return firstNumber * secondNumber;

            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("You can`t divide by zero");
                }
                return firstNumber / secondNumber;

            default:
                throw new RuntimeException("Invalid operation" + operation);
        }
    }
}
