package core.basesyntax;

public class LambdaCalc {
    public static double calculate(int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+': {
                return (double) firstNumber + secondNumber;
            }
            case '-': {
                return (double) firstNumber - secondNumber;
            }
            case '*': {
                return (double) firstNumber * secondNumber;
            }
            case '/': {
                if (secondNumber == 0) {
                    throw new ArithmeticException();
                }
                return (double) firstNumber / secondNumber;
            }
            case '^': {
                if (firstNumber == 0) {
                    throw new ArithmeticException("Raising 0 to power is undefined.");
                }
                if (firstNumber < 0 && secondNumber < 0) {
                    return Math.pow(firstNumber, secondNumber) * -1;
                }
                return Math.pow(firstNumber, secondNumber);
            }
            default: {
                throw new RuntimeException("Wrong input operation! It's only +, -, *, / and ^.");
            }
        }
    }
}
