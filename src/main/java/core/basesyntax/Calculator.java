package core.basesyntax;

public class Calculator implements Calculating {
    @Override
    public double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '^': return Math.pow(num1, num2);
            case '/': if (num2 == 0) {
                    throw new ArithmeticException("Illegal division by 0");
                }
            return num1 / num2;
            default: throw new IllegalOperatorException("Use valid operator to calculate result");
        }
    }
}
