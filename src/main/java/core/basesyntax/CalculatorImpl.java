package core.basesyntax;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatorImpl implements Calculator {
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    private static final char DIVISION_SYMBOL = '/';
    private static final char RISING_TO_A_POWER_SYMBOL = '^';
    private double firstNumber;
    private double secondNumber;
    private BigDecimal bigDecimalToCheck;

    public CalculatorImpl(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public double calculate(char operation) {
        return calculate(firstNumber, secondNumber, operation);
    }

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
            case RISING_TO_A_POWER_SYMBOL :
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
        if (bigDecimalToCheck.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0
                || bigDecimalToCheck.compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0
                || (bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) > 0
                && bigDecimalToCheck.min(BigDecimal.valueOf(Double.MIN_VALUE))
                                                   .equals(bigDecimalToCheck))
                || (bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) < 0
                && bigDecimalToCheck.max(BigDecimal.valueOf(-Double.MIN_VALUE))
                                                   .equals(bigDecimalToCheck))) {
            throwArithmeticException(operation);
        }
        return false;
    }

    private void throwArithmeticException(char operation) {
        throw new ArithmeticException(operation + " is illegal with this operands. "
                + "Result overflows double value");
    }
}
