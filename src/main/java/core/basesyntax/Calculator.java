package core.basesyntax;

import core.basesyntax.exceptions.IllegalOperationException;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char RAISING_TO_A_POWER = '^';

    public double calculate(double firstOperand, double secondOperand, char operationType) {
        double result;
        switch (operationType) {
            case ADDITION:
                result = calculateAddition(firstOperand, secondOperand);
                break;
            case SUBTRACTION:
                result = calculateSubtraction(firstOperand, secondOperand);
                break;
            case MULTIPLICATION:
                result = calculateMultiplication(firstOperand, secondOperand);
                break;
            case DIVISION:
                result = calculateDivision(firstOperand, secondOperand);
                break;
            case RAISING_TO_A_POWER:
                result = calculateRaisingToAPower(firstOperand, secondOperand);
                break;
            default:
                throw new IllegalOperationException("You try to do Illegal operation. "
                        + "Please, use only valid operations");
        }
        return result;
    }

    private double calculateAddition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private double calculateSubtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private double calculateDivision(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Can`t divide " + firstOperand + " by Zero");
        }
        return firstOperand / secondOperand;
    }

    private double calculateMultiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private double calculateRaisingToAPower(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
}
