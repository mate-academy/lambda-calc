package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class Calculator {
    public double calculate(double first, double second, char operand) {
        switch (operand) {
            case ('+'):
                return add(first, second);
            case ('-'):
                return subtract(first, second);
            case ('*'):
                return multiply(first, second);
            case ('/'):
                return divide(first, second);
            case ('^'):
                return raisingToPower(first, second);
            default:
                throw new IllegalArgumentException("Unavailable math operation.");
        }
    }

    private double add(double first, double second) {
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }

    private double multiply(double first, double second) {
        return first * second;
    }

    private double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("We cannot divide by zero");
        }
        return first / second;
    }

    private double raisingToPower(double first, double n) {
        if (first == 0) {
            throw new ArithmeticException("Just don't. https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero");
        }
        return Math.pow(first, n);
    }
}
