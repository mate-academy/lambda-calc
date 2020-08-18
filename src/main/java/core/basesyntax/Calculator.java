package core.basesyntax;

public class Calculator {
    public static double calculate(Double firstNumber, Double secondNumber, Character sign) {
        if (firstNumber == null || secondNumber == null || sign == null) {
            throw new NullPointerException("Argument or sign can't be null!");
        }
        if (String.valueOf(firstNumber).contains(",")
                || String.valueOf(secondNumber).contains(",")) {
            throw new NumberFormatException("For double digits use only point!");
        }
        switch (sign) {
            case ('+'):
                return firstNumber + secondNumber;
            case ('-'):
                return firstNumber - secondNumber;
            case ('*'):
                return firstNumber * secondNumber;
            case ('/'):
                if (secondNumber == 0) {
                    throw new ArithmeticException("Mustn't divide by zero!");
                }
                return firstNumber / secondNumber;
            case ('^'):
                if (firstNumber == 0 && secondNumber != 0) {
                    throw new AssertionError("Zero in any degree is zero!");
                }
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Entered an incorrect sign!");
        }
    }
}
