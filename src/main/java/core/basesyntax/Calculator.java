package core.basesyntax;

public class Calculator implements Calculate {

    @Override
    public double calculate(int x, int y, ArephmeticActs action) {
        switch (action) {
            case PLUS:
                return addition(x, y);
            case MINUS:
                return subtraction(x, y);
            case DIVIDE:
                return division(x, y);
            case MULTIPLY:
                return multiply(x, y);
            case POWER:
                return pow(x, y);
            default:
                throw new CalculatorException("Wrong action!");
        }
    }

    private int addition(int x, int y) {
        try {
            return Math.addExact(x, y);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Value overflow");
        }
    }

    private int subtraction(int x, int y) {
        try {
            return Math.subtractExact(x, y);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Value overflow");
        }
    }

    private int multiply(int x, int y) {
        try {
            return Math.multiplyExact(x, y);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Value overflow");
        }
    }

    private double division(int x, int y) {
        if (x == 0 || y == 0) {
            throw new CalculatorException("You can't divide by zero");
        }
        return (double) x / y;
    }

    private double pow(int number, int power) {
        if (number == 0 && power == 0) {
            throw new CalculatorException("Number and power can't be zero");
        }
        if (power == 0) {
            return 1;
        }
        double value = Math.pow(number, power);
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new CalculatorException("Wrong value");
        }
        return value;

    }
}
