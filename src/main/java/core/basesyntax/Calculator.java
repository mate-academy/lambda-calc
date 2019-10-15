package core.basesyntax;

public class Calculator {
    public double calculate(double firstNumber, double secondNumber, char operation) {
        switch (operation) {
            case '+':
                return addition(firstNumber, secondNumber);
            case '-':
                return subtraction(firstNumber, secondNumber);
            case '*':
                return multiplication(firstNumber, secondNumber);
            case '/':
                return division(firstNumber, secondNumber);
            case '^':
                return exponentiation(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("Incorrect operation.");
        }
    }

    private double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return firstNumber / secondNumber;
    }

    private double exponentiation(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
