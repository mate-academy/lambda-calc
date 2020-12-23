package core.basesyntax;

public class Calculator implements CalculatorService {
    @Override
    public double calculator(int firstElement, int secondElement, char operator) {
        switch (operator) {
            case ('+') :
                long additionResult = (long) firstElement + secondElement;
                checksBound(additionResult);
                return additionResult;
            case ('-') :
                long subtractionResult = (long) firstElement - secondElement;
                checksBound(subtractionResult);
                return subtractionResult;
            case ('*') :
                long multiplicationResult = (long) firstElement * secondElement;
                checksBound(multiplicationResult);
                return multiplicationResult;
            case ('/') :
                if (secondElement == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return (double) firstElement / secondElement;
            case ('^') :
                double raisingResult = Math.pow(firstElement, secondElement);
                checksBound((long) raisingResult);
                return raisingResult;
            default:
                throw new ArithmeticException("Your operation is not allowed: " + operator);
        }
    }

    private void checksBound(long result) {
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result out of bound for int values");
        }
    }
}
