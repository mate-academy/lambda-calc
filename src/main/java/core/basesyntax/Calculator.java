package core.basesyntax;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operation) {
        switch (operation) {
            case '+':
                return add(firstOperand, secondOperand);
            case '-':
                return subtract(firstOperand, secondOperand);
            case '*':
                return multiply(firstOperand, secondOperand);
            case '/':
                return divide(firstOperand, secondOperand);
            case '^':
                return power(firstOperand, secondOperand);
            default:
                throw new IllegalArgumentException("Operation not supported");
        }
    }

    private double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private double divide(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return firstOperand / secondOperand;
    }

    private double power(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
}
