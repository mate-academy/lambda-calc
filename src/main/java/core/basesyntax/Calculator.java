package core.basesyntax;

public class Calculator implements Calculating {
    @Override
    public double calculate(double firstNumber, double SecondNumber, char operator) {
        switch (operator) {
            case '+': return firstNumber + SecondNumber;
            case '-': return firstNumber - SecondNumber;
            case '*': return firstNumber * SecondNumber;
            case '^': return Math.pow(firstNumber, SecondNumber);
            case '/': if (SecondNumber == 0) {
                    throw new ArithmeticException("Illegal division by 0");
                }
            return firstNumber / SecondNumber;
            default: throw new IllegalOperatorException("Invalid operator" + operator);
        }
    }
}
