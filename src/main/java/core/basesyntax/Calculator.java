package core.basesyntax;

public class Calculator {
    public double calculate(double firstDigit, double secondDigit, char operation) {
        if (operation == '+') {
            return firstDigit + secondDigit;
        }
        if (operation == '-') {
            return firstDigit - secondDigit;
        }
        if (operation == '/') {
            if (secondDigit == 0) {
                throw new ArithmeticException("You can't divide by zero");
            }
            return firstDigit / secondDigit;
        }
        if (operation == '*') {
            return firstDigit * secondDigit;
        }
        if (operation == '^') {
            return Math.pow(firstDigit, secondDigit);
        }
        throw new RuntimeException("Illegal operation symbol: " + operation);
    }
}
