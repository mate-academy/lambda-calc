package core.basesyntax;

public class Calculator {
    public double calculate(double firstDigit, double secondDigit, char operator) {
        switch (operator) {
            case '+':
                return firstDigit + secondDigit;
            case '-':
                return firstDigit - secondDigit;
            case '*':
                return firstDigit * secondDigit;
            case '/':
                if (secondDigit == 0) {
                    throw new ArithmeticException("Dividing by zero forbidden");
                }
                return firstDigit / secondDigit;
            case '^':
                if (firstDigit < 0 && secondDigit < 1) {
                    throw new ArithmeticException("Negative number can't "
                            + "be raised to power less than 1 ");
                }
                return Math.pow(firstDigit, secondDigit);
            default:
                throw new UnsupportedOperationException("Operator was not defined properly");
        }
    }
}
