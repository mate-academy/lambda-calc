package core.basesyntax;

public class Calculator {

    public double calculate(double firstOperand, double secondOperator, char operation) {
        switch (operation) {
            case '+':
                return firstOperand + secondOperator;
            case '-':
                return firstOperand - secondOperator;
            case '*':
                return firstOperand * secondOperator;
            case '/':
                if (secondOperator == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstOperand / secondOperator;
            case '^':
                return Math.pow(firstOperand, secondOperator);
            default:
                throw new IllegalArgumentException("Illegal argument operation");
        }
    }
}
