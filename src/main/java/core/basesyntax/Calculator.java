package core.basesyntax;

public class Calculator {
    public double calculate(double firstDigit, double secondDigit, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = firstDigit + secondDigit;
                break;
            case '-':
                result = firstDigit - secondDigit;
                break;
            case '*':
                result = firstDigit * secondDigit;
                break;
            case '/':
                if (secondDigit == 0) {
                    throw new ArithmeticException("Dividing by zero forbidden");
                } else {
                    result = firstDigit / secondDigit;
                }
                break;
            case '^':
                if (firstDigit < 0 && secondDigit < 1) {
                    throw new ArithmeticException("Negative number can't "
                            + "be raised to power less than 1 ");
                } else {
                    result = Math.pow(firstDigit, secondDigit);
                    break;
                }
            default:
                throw new UnsupportedOperationException("Operator was not defined properly");
        }
        return result;
    }
}
