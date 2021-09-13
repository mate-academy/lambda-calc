package core.basesyntax;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatorImpl implements Calculator {
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    private static final char DIVISION_SYMBOL = '/';
    private static final char RAISING_TO_A_POWER_SYMBOL = '^';
    private BigDecimal bigDecimalToCheck;

    @Override
    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case ADDITION_SYMBOL :
                return add(firstNumber, secondNumber, operation);
            case SUBTRACTION_SYMBOL :
                return subtract(firstNumber, secondNumber, operation);
            case MULTIPLICATION_SYMBOL :
                return multiply(firstNumber, secondNumber, operation);
            case DIVISION_SYMBOL :
                return divide(firstNumber, secondNumber, operation);
            case RAISING_TO_A_POWER_SYMBOL :
                if (firstNumber < 0 && secondNumber - (int) secondNumber != 0) {
                    throw new ArithmeticException("Can't raise negative number to double power.");
                }
                return pow(firstNumber, secondNumber, operation);
            default :
                throw new RuntimeException("Illegal operation!");
        }
    }

    private double add(double firstNumber, double secondNumber, char operation) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).add(BigDecimal.valueOf(secondNumber));
        checkForOverflow(operation);
        return firstNumber + secondNumber;
    }

    private double subtract(double firstNumber, double secondNumber, char operation) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber)
                .subtract(BigDecimal.valueOf(secondNumber));
        checkForOverflow(operation);
        return firstNumber - secondNumber;
    }

    private double multiply(double firstNumber, double secondNumber, char operation) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber)
                .multiply(BigDecimal.valueOf(secondNumber));
        checkForOverflow(operation);
        return firstNumber * secondNumber;
    }

    private double divide(double firstNumber, double secondNumber, char operation) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber)
                .divide(BigDecimal.valueOf(secondNumber), RoundingMode.CEILING);
        checkForOverflow(operation);
        return firstNumber / secondNumber;
    }

    private double pow(double firstNumber, double secondNumber, char operation) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).pow((int) Math.round(secondNumber),
                                             new MathContext(4,RoundingMode.CEILING));
        checkForOverflow(operation);
        return Math.pow(firstNumber, secondNumber);
    }

    private boolean checkForOverflow(char operation) {
        if (isBiggerThanMax(bigDecimalToCheck)
                || isSmallerThanMinusMax(bigDecimalToCheck)
                || isBiggerThanZeroButSmallerThanMin(bigDecimalToCheck)
                || isSmallerThanZeroButBiggerThanMinusMin(bigDecimalToCheck)) {
            throw new ArithmeticException(operation + " is illegal with this operands. "
                    + "Result overflows double value");
        }
        return false;
    }

    private boolean isBiggerThanMax(BigDecimal bigDecimalToCheck) {
        return bigDecimalToCheck.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0;
    }

    private boolean isSmallerThanMinusMax(BigDecimal bigDecimalToCheck) {
        return bigDecimalToCheck.compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0;
    }

    private boolean isBiggerThanZeroButSmallerThanMin(BigDecimal bigDecimalToCheck) {
        return bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) > 0
                && bigDecimalToCheck.min(BigDecimal.valueOf(Double.MIN_VALUE))
                .equals(bigDecimalToCheck);
    }

    private boolean isSmallerThanZeroButBiggerThanMinusMin(BigDecimal bigDecimalToCheck) {
        return bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) < 0
                && bigDecimalToCheck.max(BigDecimal.valueOf(-Double.MIN_VALUE))
                .equals(bigDecimalToCheck);
    }
}
