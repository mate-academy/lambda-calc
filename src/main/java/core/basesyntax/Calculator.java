package core.basesyntax;

public class Calculator {
    public double calculate(double a, double b, char operation) throws ValidationExceptions {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("ERROR ! Division by zero impossible");
                }
                return a / b;
            case '*':
                return a * b;
            case '^':
                return Math.pow(a,b);
            default:
                throw new ValidationExceptions("Ups.... Something went wrong, try another symbol");
        }
    }
}
