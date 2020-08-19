package core.basesyntax;

public class Calculator {
    public double calc(double num1, double num2, char operation) {
        switch (operation) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return doDivision(num1, num2);
            case '^': return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException(
                        "Unsupported math operation. Enter from [+ - * / ^]");
        }
    }

    private static double doDivision(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return num1 / num2;
    }
}
