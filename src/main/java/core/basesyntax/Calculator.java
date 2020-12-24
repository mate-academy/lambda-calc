package core.basesyntax;

public class Calculator implements Calculable {

    public double calculate(double first, double second, char operation) {
        switch (operation) {
            case '+' :
                return add(first, second);
            case '-' :
                return subtract(first, second);
            case '/' :
                return divide(first, second);
            case '*' :
                return multiply(first, second);
            case '^' :
                return power(first, second);
            default: throw new RuntimeException("Wrong operation");
        }
    }

    private double add(double first, double second) {
        checkMaxValues(first, second, '+');
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }

    private double divide(double first, double second) {
        if (second == 0) {
            throw new RuntimeException("Division by zero is prohibited");
        }
        return first / second;
    }

    private double multiply(double first, double second) {
        checkMaxValues(first, second, '*');
        return first * second;
    }

    private double power(double first, double second) {
        if (first == 0 && second < 0) {
            throw new RuntimeException("Zero power negative is prohibited");
        }
        if (first < 0 && second > 0 && second < 1) {
            throw new RuntimeException("Negative power fractional is prohibited");
        }
        return Math.pow(first, second);
    }

    private void checkMaxValues(double first, double second, char operation) {
        if (first == Double.MAX_VALUE && second == Double.MAX_VALUE) {
            throw new RuntimeException("Operation " + operation + " two max values is prohibited");
        }
        if (first == Double.MAX_VALUE || second == Double.MAX_VALUE) {
            throw new RuntimeException("Operation " + operation + " with max value is prohibited");
        }
    }
}
