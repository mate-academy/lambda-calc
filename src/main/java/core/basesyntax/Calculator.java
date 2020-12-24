package core.basesyntax;

public class Calculator {
    public double calculate(double firstVariable, double secondVariable, char operation) {
        switch (operation) {
            case '+':
                isResultInBoundForMax(firstVariable, secondVariable);
                return firstVariable + secondVariable;
            case '-':
                isResultInBoundForMin(firstVariable, secondVariable);
                return firstVariable - secondVariable;
            case '*':
                isResultInBoundForMax(firstVariable, secondVariable);
                return firstVariable * secondVariable;
            case '/':
                if (secondVariable == 0) {
                    throw new ArithmeticException("You can`t divide by zero");
                }
                isResultInBoundForMin(firstVariable, secondVariable);
                return firstVariable / secondVariable;
            case '^':
                isResultInBoundForMax(firstVariable, secondVariable);
                return Math.pow(firstVariable, secondVariable);
            default:
                throw new NotValidOperationException("Not valid operation!");
        }
    }

    private void isResultInBoundForMax(double firstVariable, double secondVariable) {
        if (firstVariable == Double.MAX_VALUE
                || secondVariable == Double.MAX_VALUE) {
            throw new ValueOutOfBoundException("Your result is out of bound.");
        }
    }

    private void isResultInBoundForMin(double firstVariable, double secondVariable) {
        if (firstVariable == Double.MIN_VALUE
                || secondVariable == Double.MIN_VALUE) {
            throw new ValueOutOfBoundException("Your result is out of bound.");
        }
    }
}
