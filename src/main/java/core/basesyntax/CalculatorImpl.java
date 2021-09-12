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
    public double calculate(char action) {
        return calculate(firstNumber, secondNumber, action);
    }

    @Override
    public double calculate(double firstNumber, double secondNumber, char action) {
        switch (action) {
            case ADDITION_SYMBOL :
                return add(firstNumber, secondNumber, action);
            case SUBTRACTION_SYMBOL :
                return subtract(firstNumber, secondNumber, action);
            case MULTIPLICATION_SYMBOL :
                return multiply(firstNumber, secondNumber, action);
            case  DIVISION_SYMBOL :
                return divide(firstNumber, secondNumber, action);
            case RISING_TO_A_POWER_SYMBOL :
                return pow(firstNumber, secondNumber, action);
            default :
            throw new RuntimeException("Illegal operation!");
        }
    }

    private double add(double firstNumber, double secondNumber, char action) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).add(BigDecimal.valueOf(secondNumber));
        checkForOverflow(action);
        return firstNumber + secondNumber;
    }

    private double subtract(double firstNumber, double secondNumber, char action) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).subtract(BigDecimal.valueOf(secondNumber));
        checkForOverflow(action);
        return firstNumber - secondNumber;
    }

    private double multiply(double firstNumber, double secondNumber, char action) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).multiply(BigDecimal.valueOf(secondNumber));
        checkForOverflow(action);
        return firstNumber * secondNumber;
    }

    private double divide(double firstNumber, double secondNumber, char action) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).divide(BigDecimal.valueOf(secondNumber), RoundingMode.CEILING);
        checkForOverflow(action);
        return firstNumber / secondNumber;
    }

    private double pow(double firstNumber, double secondNumber, char action) {
        bigDecimalToCheck = BigDecimal.valueOf(firstNumber).pow((int) Math.round(secondNumber), new MathContext(4,RoundingMode.CEILING));
        checkForOverflow(action);
        return Math.pow(firstNumber, secondNumber);
    }

    private boolean checkForOverflow(char action) {
        if (bigDecimalToCheck.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0
                   || bigDecimalToCheck.compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0
                   || (bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) > 0
                   && bigDecimalToCheck.min(BigDecimal.valueOf(Double.MIN_VALUE)).equals(bigDecimalToCheck))
                   || (bigDecimalToCheck.compareTo(BigDecimal.valueOf(0)) < 0
                   && bigDecimalToCheck.max(BigDecimal.valueOf(-Double.MIN_VALUE)).equals(bigDecimalToCheck))) {
            throwArithmeticException(action);
        }
        return false;
    }

    private void throwArithmeticException(char action) {
        throw new ArithmeticException(action + " is illegal with this operands. Result is overflow of double value");
    }
}
