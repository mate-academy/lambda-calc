package core.basesyntax;

public class CalculatorImpl implements Calculator {
    private double firstNumeric;
    private double secondNumeric;

    @Override
    public double calculate(double firstNumeric, char operator, double secondNumeric) {
        this.firstNumeric = firstNumeric;
        this.secondNumeric = secondNumeric;
        double result = 0;
        switch (operator) {
            case '+':
                result = addition();
                break;
            case '-':
                result = subtraction();
                break;
            case '/':
                result = division();
                break;
            case '*':
                result = multiplication();
                break;
            case '^':
                result = raisingToPower();
                break;
            default:
                throw new UnsupportedOperationException("Please use/pass in method only next "
                        + "operators: '+', '-', '/', '*', '^'(raise to power)");
        }
        return result;
    }

    private double addition() {
        if (firstNumeric == Double.MAX_VALUE || secondNumeric == Double.MAX_VALUE) {
            throw new ArithmeticException("addition of MAX_VALUE return infinity");
        }
        return firstNumeric + secondNumeric;
    }

    private double subtraction() {
        if (firstNumeric == Double.MAX_VALUE && secondNumeric == Double.MAX_VALUE) {
            throw new ArithmeticException("subtraction of two MAX_VALUE return minus infinity");
        }
        return firstNumeric - secondNumeric;
    }

    private double division() {
        if (secondNumeric == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstNumeric / secondNumeric;
    }

    private double multiplication() {
        if (firstNumeric == Double.MAX_VALUE && secondNumeric == Double.MAX_VALUE) {
            throw new ArithmeticException("multiplication of two MAX_VALUE return infinity");
        }
        return firstNumeric * secondNumeric;
    }

    private double raisingToPower() {
        if (firstNumeric == Double.MAX_VALUE && secondNumeric == Double.MAX_VALUE) {
            throw new ArithmeticException("raising to a power of two MAX_VALUE return infinity");
        }
        return Math.pow(firstNumeric, secondNumeric);
    }
}
