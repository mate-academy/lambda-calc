package core.basesyntax;

public class Calculator {

    public int calculate(int firstNumber, char operand, int secondNumber) {
        if (operand != '+' && operand != '-' && operand != '*' && operand != '/'
                && operand != '^') {
            throw new IllegalArgumentException("Wrong operand");
        }
        if (operand == '/' && (firstNumber == 0 || secondNumber == 0)) {
            throw new IllegalArgumentException("Division by zero");
        }
        return operand == '+' ? firstNumber + secondNumber : operand == '-'
                ? firstNumber - secondNumber : operand == '*' ? firstNumber * secondNumber
                : operand == '/' ? firstNumber / secondNumber
                : (int) Math.pow(firstNumber, secondNumber);
    }
}
