package core.basesyntax;

public class Calculator {
    public double calculate(double numOne, double numTwo, char operation) {
        switch (operation) {
            case '+':
                return numOne + numTwo;
            case '-':
                return numOne - numTwo;
            case '*':
                return numOne * numTwo;
            case '/':
                if (numTwo == 0) {
                    throw new ArithmeticException("You can't divide by zero");
                }
                return numOne / numTwo;
            case '^':
                return Math.pow(numOne, numTwo);
            default:
                throw new RuntimeException("Wrong operator" + operation);
        }
    }
}

