package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

    public double calculator(int first, int second, char operator) {
        Operationable operation;
        switch (operator) {
            case PLUS:
                operation = ((x, y) -> x + y);
                break;
            case MINUS:
                operation = (x, y) -> x - y;
                break;
            case MULTIPLICATION:
                operation = (x, y) -> x * y;
                break;
            case DIVISION:
                operation = (x, y) -> x / y;
                break;
            case POWER:
                operation = (x, y) -> (int) Math.pow(x, y);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
        return operation.calculate(first, second);
    }

    interface Operationable {
        int calculate(int x, int y);
    }

}
