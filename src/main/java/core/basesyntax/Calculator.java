package core.basesyntax;

public class Calculator {
    protected double calculate(double firstOperand, char symbolOperand, double secondOperand) {
        switch (symbolOperand) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException("Division by zero is not possible!");
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }
}
