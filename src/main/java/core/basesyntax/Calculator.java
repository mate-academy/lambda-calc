package core.basesyntax;

public class Calculator {

    public double calculate(double firstVariable,double secondVariable,char operation) {
        switch (operation) {
            case '+':
                if (firstVariable == Double.MAX_VALUE
                        || secondVariable == Double.MAX_VALUE) {
                    throw new ValueOutOfBoundException("Your value more than Double max value.");
                }
                return firstVariable + secondVariable;
            case '-':
                if (firstVariable == Double.MIN_VALUE
                    || secondVariable == Double.MIN_VALUE) {
                throw new ValueOutOfBoundException("Your value more than Double min value.");
            }
                return firstVariable - secondVariable;
            case '*':
                if (firstVariable == Double.MAX_VALUE
                        || secondVariable == Double.MAX_VALUE) {
                    throw new ValueOutOfBoundException("Your value more than Double max value.");
                }
                return firstVariable * secondVariable;
            case '/':
                if (secondVariable == 0) {
                    throw new ArithmeticException("You can`t divide by zero");
                } else if (firstVariable == Double.MIN_VALUE
                        || secondVariable == Double.MIN_VALUE) {
                    throw new ValueOutOfBoundException("Your value more than Double min value.");
                }
                return firstVariable / secondVariable;
            case '^':
                if (firstVariable == Double.MAX_VALUE
                        || secondVariable == Double.MAX_VALUE) {
                    throw new ValueOutOfBoundException("Your value more than Double max value.");
                }
                return Math.pow(firstVariable, secondVariable);
            default:
                throw new NotValidOperationException("Not valid operation!");
        }
    }
}
