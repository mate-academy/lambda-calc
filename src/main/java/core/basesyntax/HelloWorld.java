package core.basesyntax;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public double calculate(double firstDigit, double secondDigit, char operand) {
        switch (operand) {
            case ('+'):
                return addition(firstDigit, secondDigit);
            case ('-'):
                return subtraction(firstDigit, secondDigit);
            case ('/'):
                return division(firstDigit, secondDigit);
            case ('*'):
                return multiplication(firstDigit, secondDigit);
            case ('^'):
                return raisingToPower(firstDigit, secondDigit);
            default:
                throw new IllegalArgumentException();
        }
    }

    private double addition(double firstDigit, double secondDigit) {
        return firstDigit + secondDigit;
    }

    private double subtraction(double firstDigit, double secondDigit) {
        return firstDigit - secondDigit;
    }

    private double division(double firstDigit, double secondDigit) {
        if (secondDigit == 0) {
            throw new ArithmeticException();
        }
        return firstDigit / secondDigit;
    }

    private double multiplication(double firstDigit, double secondDigit) {
        return firstDigit * secondDigit;
    }

    private double raisingToPower(double firstDigit, double n) {
        double result = 1;
        for (double i = 1; i <= n; i++) {
            result = result * firstDigit;
        }
        return result;
    }
}
