package core.basesyntax;

public class Calculator {
    public double calculate(Double firstNumber, Double secondNumber, Character sign) {
        if (firstNumber == null || secondNumber == null || sign == null) {
            throw new IllegalArgumentException("Argument or sign can't be null!");
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
                if (firstNumber == 0 && secondNumber < 0) {
                    throw new ArithmeticException("Zero in any minus degree is zero!");
                }
                return Math.pow(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Entered an incorrect sign!");
        }
    }
}
