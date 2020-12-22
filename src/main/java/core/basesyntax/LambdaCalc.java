package core.basesyntax;

public class LambdaCalc {
    public static double calculate(int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+': {
                if (firstNumber == Integer.MAX_VALUE
                        || secondNumber == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (double) firstNumber + secondNumber;
            }
            case '-': {
                if (firstNumber == Integer.MIN_VALUE
                        || secondNumber == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                return (double) firstNumber - secondNumber;
            }
            case '*': {
                if (firstNumber == Integer.MAX_VALUE
                        || secondNumber == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (firstNumber == Integer.MIN_VALUE
                        || secondNumber == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                return (double) firstNumber * secondNumber;
            }
            case '/': {
                if (firstNumber == Integer.MAX_VALUE
                        || secondNumber == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (firstNumber == Integer.MIN_VALUE
                        || secondNumber == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (secondNumber == 0) {
                    throw new ArithmeticException();
                }
                return (double) firstNumber / secondNumber;
            }
            case '^': {
                if (firstNumber == Integer.MAX_VALUE
                        || secondNumber == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (firstNumber == Integer.MIN_VALUE
                        || secondNumber == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (firstNumber == 0) {
                    throw new ArithmeticException("Raising 0 to power is undefined.");
                }
                return Math.pow(firstNumber, secondNumber);
            }
            default: {
                throw new RuntimeException("Wrong input operation! It's only +, -, *, / and ^.");
            }
        }
    }
}
