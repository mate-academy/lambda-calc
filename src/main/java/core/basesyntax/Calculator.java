package core.basesyntax;

public class Calculator {
    public double calculate(double number1, double number2, char operationType) {
        switch (operationType) {
            case ('+'):
                return number1 + number2;
            case ('-'):
                return number1 - number2;
            case ('*'):
                return number1 * number2;
            case ('/'):
                if (number2 == 0) {
                    throw new ArithmeticException();
                }
                return number1 / number2;
            case ('^'):
                if (number1 < 0) {
                    return Math.pow(number1 * -1, number2) * -1;
                }
                return Math.pow(number1, number2);
            default:
                throw new UnsupportedOperationException("Wrong operation type");
        }
    }
}
