package core.basesyntax;

public class LambdaCalc {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case ADDITION:
                return calculatorAddition(firstNumber, secondNumber);
            case SUBTRACTION:
                return calculatorSubtraction(firstNumber, secondNumber);
            case MULTIPLICATION:
                return calculatorMultiplication(firstNumber, secondNumber);
            case DIVISION:
                return calculatorDivision(firstNumber, secondNumber);
            case POWER:
                return calculatorPower(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Operation don't exist!");
        }
    }

    private double calculatorAddition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double calculatorSubtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double calculatorMultiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double calculatorDivision(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by zero is prohibited!");
        }
        return firstNumber / secondNumber;
    }

    private double calculatorPower(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
