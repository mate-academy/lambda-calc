package core.basesyntax;

import core.basesyntax.exception.InvalidOperatorException;

public class Calculator {
    public double calculate(double leftOperand, double rightOperand, char operator) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '/':
                if (leftOperand == 0 || rightOperand == 0) {
                    throw new ArithmeticException("Can not divide by zero");
                } else {
                    return leftOperand / rightOperand;
                }
            case '*':
                return leftOperand * rightOperand;
            case '^':
                return Math.pow(leftOperand, rightOperand);
            default:
                throw new InvalidOperatorException("Invalid operator");

        }
    }
}




