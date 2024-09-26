package core.basesyntax;

public class Calculator implements CalculatorService {
    private static final char OPERATION_ADDITION = '+';
    private static final char OPERATION_SUBTRACTION = '-';
    private static final char OPERATION_DIVISION = '/';
    private static final char OPERATION_MULTIPLICATION = '*';
    private static final char OPERATION_RAISING_TO_A_POWER = '^';

    public double calculate(double firstArgument, double secondArgument, char operation) {
        switch (operation) {
            case OPERATION_ADDITION :
                return calculateAddition(firstArgument, secondArgument);
            case OPERATION_SUBTRACTION :
                return calculateSubtraction(firstArgument, secondArgument);
            case OPERATION_DIVISION :
                return calculateDivision(firstArgument, secondArgument);
            case OPERATION_MULTIPLICATION :
                return calculateMultiplication(firstArgument, secondArgument);
            case OPERATION_RAISING_TO_A_POWER :
                return calculateRaisingToAPower(firstArgument, secondArgument);
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    @Override
    public double calculateAddition(double firstArgument, double secondArgument) {
        double result = firstArgument + secondArgument;
        if (result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Negative infinity");
        }
        if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        return result;
    }

    @Override
    public double calculateSubtraction(double firstArgument, double secondArgument) {
        double result = firstArgument - secondArgument;
        if (result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Negative infinity");
        }
        if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        return result;
    }

    @Override
    public double calculateDivision(double firstArgument, double secondArgument) {
        double result = firstArgument / secondArgument;
        if (result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Negative Infinity");
        }
        if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        if (Double.isNaN(result)) {
            throw new ArithmeticException("NaN");
        }
        return result;
    }

    @Override
    public double calculateMultiplication(double firstArgument, double secondArgument) {
        double result = firstArgument * secondArgument;
        if (result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Negative Infinity");
        }
        if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        return result;
    }

    @Override
    public double calculateRaisingToAPower(double firstArgument, double secondArgument) {
        double result = Math.pow(firstArgument, secondArgument);
        if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinity");
        }
        if (Double.isNaN(result)) {
            throw new ArithmeticException("NaN");
        }
        return result;
    }
}
