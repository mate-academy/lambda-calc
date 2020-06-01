package core.basesyntax;

import core.basesyntax.exceptions.DataProcessingException;

public class Calculator {
    public static Integer calculate(int firstNumber, int secondNumber, char sign) {
        if (sign == '-') {
            return firstNumber - secondNumber;
        } else if (sign == '+') {
            return firstNumber + secondNumber;
        } else if (sign == '*') {
            return firstNumber * secondNumber;
        } else if (sign == '/' && secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            throw new DataProcessingException("Sorry, something is wrong!");
        }
    }
}
