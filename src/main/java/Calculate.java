import java.util.NoSuchElementException;

public class Calculate {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char DIVISION = '/';
    public static final char MULTIPLICATION = '*';
    public static final char EXPONENTIATION = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case PLUS:
                return getTheAmountResult(firstNumber, secondNumber);
            case MINUS:
                return getTheSubtractionResult(firstNumber, secondNumber);
            case DIVISION:
                return getTheDivisionResult(firstNumber, secondNumber);
            case MULTIPLICATION:
                return getTheMultiplicationResult(firstNumber, secondNumber);
            case EXPONENTIATION:
                return getTheExponentiationResult(firstNumber, secondNumber);
            default:
                throw new NoSuchElementException("Incorrect operation");

        }
    }

    private double getTheAmountResult(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double getTheSubtractionResult(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double getTheDivisionResult(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("We can't divide by zero");
        }
        return firstNumber / secondNumber;
    }

    private double getTheMultiplicationResult(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double getTheExponentiationResult(double firstNumber, double secondNumber) {
        if (firstNumber == 0 && secondNumber < 0) {
            throw new ArithmeticException("We can't divide by zero");
        }
        return Math.pow(firstNumber, secondNumber);
    }
}
