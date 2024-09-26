package core.basesyntax;

public class Calculator {
    public double calculate(double firstNumber, double secondNumber, char operand) {
        switch (operand) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Indicated dividing by zero as exception "
                            + "by the IEEE 754 standard");
                }
                return firstNumber / secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '^':
                return Math.pow(firstNumber, (long) (secondNumber));
            default:
                throw new RuntimeException("Unknown operation : " + operand);
        }
    }
}
