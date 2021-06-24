package core.basesyntax;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    public double calculate(double firstOperand, double secondOperand, char operation) {
        if (operation == ADDITION) {
            return firstOperand + secondOperand;
        }
        if (operation == SUBTRACTION) {
            return firstOperand - secondOperand;
        }
        if (operation == MULTIPLICATION) {
            return firstOperand * secondOperand;
        }
        if (operation == DIVISION) {
            if (secondOperand == 0) {
                throw new ArithmeticException("Can't divide by zero!");
            }
            return firstOperand / secondOperand;
        }
        if (operation == POWER) {
            if (firstOperand == 0 && secondOperand < 0) {
                throw new ArithmeticException("Zero can't have negative power!");
            }
            return Math.pow(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException("This operation is unsupported!");
    }
}
