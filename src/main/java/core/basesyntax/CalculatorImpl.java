package core.basesyntax;

import core.basesyntax.exceptions.UnknownOperationException;
import core.basesyntax.exceptions.ZeroDivisionException;
import core.basesyntax.service.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return addition(firstOperand, secondOperand);
            case '-':
                return substraction(firstOperand, secondOperand);
            case '*':
                return multiplication(firstOperand, secondOperand);
            case '/':
                return division(firstOperand, secondOperand);
            case '^':
                return toPower(firstOperand, secondOperand);
            default:
                throw new UnknownOperationException("Operator: " + operator + " is unknown!");
        }
    }

    private double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private double substraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private double division(double firstOperand, double secondOperand) {
        if (firstOperand != 0.0d && secondOperand == 0) {
            throw new ZeroDivisionException("Division by zero!");
        }
        return firstOperand / secondOperand;
    }

    private double toPower(double firstOperand, double powerOperand) {
        return Math.pow(firstOperand, powerOperand);
    }
}
