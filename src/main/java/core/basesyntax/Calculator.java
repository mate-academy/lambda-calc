package core.basesyntax;

public class Calculator implements Calculation {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char RAISING = '^';

    @Override
    public double calculate(double value1, double value2, char operation) {
        switch (operation) {
            case PLUS:
                return addition(value1, value2);
            case MINUS:
                return subtraction(value1, value2);
            case MULTIPLY:
                return multiplication(value1, value2);
            case DIVIDE:
                return division(value1, value2);
            case RAISING:
                return raisingToPower(value1, value2);
            default:
                throw new ArithmeticException("No such operation");
        }
    }

    private double addition(double value1, double value2) {
        return value1 + value2;
    }

    private double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    private double division(double value1, double value2) {
        if (value2 != 0) {
            return value1 / value2;
        }
        throw new ArithmeticException("We cannot divide by 0.");
    }

    private double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    private double raisingToPower(double value1, double value2) {
        return Math.pow(value1, value2);
    }
}
