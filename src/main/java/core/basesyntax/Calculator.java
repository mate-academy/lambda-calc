package core.basesyntax;

public class Calculator {
    private static final double DEFAULT_VALUE = 0;
    public double calculate(double value1, double value2, char operation) {
        switch (operation) {
            case '+':
                return addition(value1, value2);
            case '-':
                return subtraction(value1, value2);
            case '*':
                return multiplication(value1, value2);
            case '/':
                return division(value1, value2);
            case '^':
                return raisingToPower(value1, value2);
            default:
                return DEFAULT_VALUE;
        }
    }

    public double addition(double value1, double value2) {
        return value1 + value2;
    }

    public double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    public double division(double value1, double value2) {
        return value1 / value2;
    }

    public double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    public double raisingToPower(double value1, double value2) {
        return Math.pow(value1, value2);
    }
}
