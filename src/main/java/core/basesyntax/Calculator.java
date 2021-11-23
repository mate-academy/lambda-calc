package core.basesyntax;

public class Calculator implements Calculating {
    @Override
    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+': return firstNumber + secondNumber;
            case '-': return firstNumber - secondNumber;
            case '*': return firstNumber * secondNumber;
            case '^': return Math.pow(firstNumber, secondNumber);
            case '/': if (secondNumber == 0) {
                    throw new ArithmeticException("Illegal division by 0");
                }
            return firstNumber / secondNumber;
            default: throw new IllegalOperatorException("Invalid operator" + operator);
        }
    }
}
