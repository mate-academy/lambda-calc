package core.basesyntax;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return addition(firstOperand, secondOperand);
            case '-':
                return subtraction(firstOperand, secondOperand);
            case '/':
                return division(firstOperand, secondOperand);
            case '*':
                return multiplication(firstOperand, secondOperand);
            case '^':
                return raiseToPower(firstOperand, secondOperand);
            default: throw new IllegalArgumentException("There is no such operation");
        }
    }

    private double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private double subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private double division(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstOperand / secondOperand;
    }

    private double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private double raiseToPower(double firstOperand, double secondOperand) {
        if (firstOperand == 0 && secondOperand < 0) {
            throw new ArithmeticException("Сan't raise zero to a negative power");
        }
        return Math.pow(firstOperand, secondOperand);
    }
}
