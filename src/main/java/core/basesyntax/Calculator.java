package core.basesyntax;

public class Calculator {

    public double calculate(double firstVariable,double secondVariable,char operation) {
        switch (operation) {
            case '+':
                return firstVariable + secondVariable;
            case '-':
                return firstVariable - secondVariable;
            case '*':
                return firstVariable * secondVariable;
            case '/':
                if (secondVariable == 0) {
                    throw new ArithmeticException("You can`t divide by zero");
                }
                return firstVariable / secondVariable;
            case '^':
                return Math.pow(firstVariable, secondVariable);
            default:
                throw new NotValidOperationException("Not valid operation!");
        }
    }
}
