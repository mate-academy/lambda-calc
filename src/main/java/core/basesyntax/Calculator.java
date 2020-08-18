package core.basesyntax;

public class Calculator {
    public static double calculate(double firstOperand, double secondOperand, char operator) {
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
            default: throw new RuntimeException("There is no such operation");
        }
    }

    private static double addition(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private static double subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private static double division(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new RuntimeException("Division by zero");
        }
        return firstOperand / secondOperand;
    }

    private static double multiplication(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private static double raiseToPower(double firstOperand, double secondOperand) {
        if (firstOperand == 0 && secondOperand < 0) {
            throw new RuntimeException("Сan't raise zero to a negative power");
        }
        return Math.pow(firstOperand, secondOperand);
    }
}
