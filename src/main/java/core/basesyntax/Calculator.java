package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(double firstNumber, double secondNumber, char operation) {
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
                throw new IllegalArgumentException("Divide on zero unavailable");
            }

            return firstNumber / secondNumber;
        }

        if (operation == '^') {
            return Math.pow(firstNumber, secondNumber);
        }

        throw new IllegalArgumentException("You can use only /, *, +, -");
    }
}
