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
        String operationName = "addition";
        double result = firstNumeric + secondNumeric;
        return checkResult(result, operationName);
    }

    private double subtraction() {
        String operationName = "subtraction";
        double result = firstNumeric - secondNumeric;
        return checkResult(result, operationName);
    }

    private double division() {
        String operationName = "division";
        if (secondNumeric == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double result = firstNumeric / secondNumeric;
        return checkResult(result, operationName);
    }

    private double multiplication() {
        String operationName = "multiplication";
        double result = firstNumeric * secondNumeric;
        return checkResult(result, operationName);
    }

    private double raisingToPower() {
        String operationName = "raisingToPower";
        double result = Math.pow(firstNumeric, secondNumeric);
        return checkResult(result, operationName);

    }

    private double checkResult(double result, String operation) {
        if (Double.isFinite(result)) {
            return result;
        }
        throw new ArithmeticException(String.format("In method %s wrong params -> "
                + "result is Infinity or NaN", operation));
    }
}
