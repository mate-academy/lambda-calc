package core.basesyntax;

public class Calculator {
    public double calculate(char operation, double fistDigit, double secondDigit) {
        switch (operation) {
            case '+':
                return fistDigit + secondDigit;
            case '-':
                return fistDigit - secondDigit;
            case '*':
                return fistDigit * secondDigit;
            case '/':
                if (secondDigit == 0) {
                    throw new ArithmeticException("Cannot be divided by zero");
                }
                return fistDigit / secondDigit;
            case '^':
                return Math.pow(fistDigit, secondDigit);
            default:
                throw new IllegalArgumentException("Enter correct operation");
        }
    }
}
