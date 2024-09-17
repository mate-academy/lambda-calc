package core.basesyntax;

public class Calculator {
    private static final String DIVISION_BY_ZERO = "Division by zero.";
    private static final String UNEXPECTED_OPERATOR = "Unexpected operator ";

    public double calculate(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                if (secondOperand == 0) {
                    throw new ArithmeticException(DIVISION_BY_ZERO);
                }
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '^':
                return Math.pow(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException(UNEXPECTED_OPERATOR + operator);
        }
    }
}
