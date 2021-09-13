package core.basesyntax;

public class Calculator implements Calculation {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char RAISING = '^';

    @Override
    public double calculate(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case PLUS:
                return addition(firstValue, secondValue);
            case MINUS:
                return subtraction(firstValue, secondValue);
            case MULTIPLY:
                return multiplication(firstValue, secondValue);
            case DIVIDE:
                return division(firstValue, secondValue);
            case RAISING:
                return raisingToPower(firstValue, secondValue);
            default:
                throw new IllegalArgumentException("No such operation");
        }
    }

    private double addition(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    private double subtraction(double firstValule, double secondValue) {
        return firstValule - secondValue;
    }

    private double division(double firstValue, double secondValue) {
        if (secondValue != 0) {
            return firstValue / secondValue;
        }
        throw new ArithmeticException("We cannot divide by 0.");
    }

    private double multiplication(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    private double raisingToPower(double firstValue, double secondValue) {
        return Math.pow(firstValue, secondValue);
    }
}
