package core.basesyntax;

public class CalculatorImpl implements Calculator {
    public double calculate(double firstElement, double secondElement, char operation) {

        switch (operation) {
            case ('+'):
                return firstElement + secondElement;
            case ('-'):
                return firstElement - secondElement;
            case ('*'):
                return firstElement * secondElement;
            case ('/'):
                if (secondElement == 0) {
                    throw new ArithmeticException("Can't divide on zero");
                }
                return firstElement / secondElement;
            case ('^'):
                return Math.pow(firstElement, secondElement);
            default:
                throw new IllegalArgumentException("Wrong operation: " + operation);
        }
    }
}

