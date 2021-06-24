package core.basesyntax;

public class LambdaCalc {

    public LambdaCalc() {
    }

    public double calculate(double firstNumber, double secondNumber, char operation) {
        if (operation == '+') {
            return calculatorSum(firstNumber, secondNumber);
        }
        if (operation == '-') {
            return calculatorSubtraction(firstNumber, secondNumber);
        }
        if (operation == '*') {
            return calculatorMultiplication(firstNumber, secondNumber);
        }
        if (operation == '/') {
            return calculatorDivision(firstNumber, secondNumber);
        }
        if (operation == '^') {
            return calculatorPower(firstNumber, secondNumber);
        }
        if (operation != '+' || operation == '-'
                || operation == '*'
                || operation == '/'
                || operation == '^') {
            throw new IllegalArgumentException("Operation don't exist!");
        }

        return 0;
    }

    private double calculatorSum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    private double calculatorSubtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    private double calculatorMultiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    private double calculatorDivision(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by zero is prohibited!");
        }
        return firstNumber / secondNumber;
    }

    private double calculatorPower(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
