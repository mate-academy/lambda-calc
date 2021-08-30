package core.basesyntax;

public class Calculator {
    public double calculate(double firstParam, double secondParam, char operation) {
        switch (operation) {
            case '+':
                return firstParam + secondParam;
            case '-':
                return firstParam - secondParam;
            case '/':
                if (secondParam == 0) {
                    throw new ArithmeticException("You can't divide by 0");
                }
                return firstParam / secondParam;
            case '*':
                return firstParam * secondParam;
            case '^':
                return Math.pow(firstParam, secondParam);
            default:
                throw new ArithmeticException("Invalid operation");
        }
    }
}
