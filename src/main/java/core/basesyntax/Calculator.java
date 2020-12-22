package core.basesyntax;

public class Calculator implements ArithmeticOperations {
    @Override
    public double calculator(int firstElement, int secondElement, char operator) {
        switch (operator) {
            case ('+') :
                long sum = (long) firstElement + secondElement;
                checkingBound(sum);
                return sum;
            case ('-') :
                long subtractionResult = (long) firstElement - secondElement;
                checkingBound(subtractionResult);
                return subtractionResult;
            case ('*') :
                long multiplicationResult = (long) firstElement * secondElement;
                checkingBound(multiplicationResult);
                return multiplicationResult;
            case ('/') :
                if (secondElement == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return firstElement / secondElement;
            case ('^') :
                double raisingResult = Math.pow((long) firstElement, secondElement);
                checkingBound((long) raisingResult);
                return raisingResult;
            default:
                throw new ArithmeticException("Your operation is not allowed" + operator);
        }
    }

    private void checkingBound(long result) {
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Result out of bound for int values");
        }
    }
}
