package core.basesyntax;

public class LambdaCalc {
    public double calculate(int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+': {
                return firstNumber + secondNumber;
            }
            case '-': {
                return firstNumber - secondNumber;
            }
            case '*': {
                if (firstNumber == Integer.MAX_VALUE || secondNumber == Integer.MAX_VALUE
                        || firstNumber == Integer.MIN_VALUE || secondNumber == Integer.MIN_VALUE) {
                    throw new RuntimeException("Result is undefined");
                }
                return firstNumber * secondNumber;
            }
            case '/': {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is undefined.");
                }
                if (firstNumber == 0) {
                    return 0;
                }
                return (double) firstNumber / secondNumber;
            }
            case '^': {
                return Math.pow(firstNumber, secondNumber);
            }
            default: {
                throw new RuntimeException("Wrong input operation! It's only +, -, *, / and ^.");
            }
        }
    }
}
