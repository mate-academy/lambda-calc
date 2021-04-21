package core.basesyntax;

public class CalculatorImpl implements Calculator {
    public double calculate(double firstElement, double secondElement, char operation) {
        double result;

        switch (operation) {
            case ('+'):
                result = firstElement + secondElement;
                break;
            case ('-'):
                result = firstElement - secondElement;
                break;
            case ('*'):
                result = firstElement * secondElement;
                break;
            case ('/'):
                if (secondElement == 0) {
                    throw new ArithmeticException();
                }
                result = firstElement / secondElement;
                break;
            case ('^'):
                result = Math.pow(firstElement, secondElement);
                break;
            default:
                throw new IllegalArgumentException("Wrong operation: " + operation);
        }
        return result;
    }
}

