package core.basesyntax;

public class Calculator implements ArithmeticOperations {
    @Override
    public double calculator(int firstElement, int secondElement, char operator) {
        switch (operator) {
            case ('+') :
                long result = (long) firstElement + (long) secondElement;
                checkingBound(result);
                return result;
            case ('-') :
                long result1 = (long) firstElement - (long) secondElement;
                checkingBound(result1);
                return result1;
            case ('*') :
                long result2 = (long) firstElement * (long) secondElement;
                checkingBound(result2);
                return result2;
            case ('/') :
                return (long)(firstElement / secondElement);
            case ('^') :
                double result3 = Math.pow((long) firstElement, (long) secondElement);
                checkingBound((long) result3);
                return result3;
            default:
                throw new RuntimeException("Your operation is not allowed" + operator);
        }
    }

    private void checkingBound(long result) {
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new RuntimeException("Result out of bound for int values");
        }
    }
}
