package core.basesyntax;

public class LambdaCalculator implements Calculator {

    @Override
    public double calculate(double parameter1, double parameters2, char operation) {
        switch (operation) {
            case '+':
                return parameter1 + parameters2;
            case '*':
                return parameter1 * parameters2;
            case '/':
                if (parameters2 == 0) {
                    throw new ArithmeticException("division by zero!");
                }
                return parameter1 / parameters2;
            case '-':
                return parameter1 - parameters2;
            case '^':
                return Math.pow(parameter1,parameters2);
            default:
                throw new ArithmeticException("Unexpected operation");
        }
    }
}
