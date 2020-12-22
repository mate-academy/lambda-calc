package core.basesyntax;

public class LambdaCalc {
    public static double calculate(int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+': {
                return firstNumber + secondNumber;
            }
            case '-': {
                return firstNumber - secondNumber;
            }
            case '*': {
                checkForEdges(firstNumber, secondNumber);
                return firstNumber * secondNumber;
            }
            case '/': {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is undefined.");
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

    private static void checkForEdges(int first, int second) {
        if (first == Integer.MAX_VALUE || second == Integer.MAX_VALUE
                || first == Integer.MIN_VALUE || second == Integer.MIN_VALUE) {
            throw new RuntimeException("Result is undefined");
        }
    }
}
