package core.basesyntax;

public class Calculator {
    private double firstNumber;
    private double secondNumber;

    public Calculator() {
    }

    public Calculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double calculate(double firstNumber, double secondNumber, char action) {
        if (action == '+') {
            if (firstNumber / 2 + secondNumber / 2 <= Double.MAX_VALUE / 2) {
                return firstNumber + secondNumber;
            }
            throw new ArithmeticException("Illegal operands! Addition is bigger than the max value of Double");
        }
        if (action == '-') {
            return firstNumber - secondNumber;
        }
        if (action == '*') {
            return firstNumber * secondNumber;
        }
        if (action == '/') {
            return firstNumber / secondNumber;
        }
        if (action == '^') {
            return Math.pow(firstNumber, secondNumber);
        }
        throw new RuntimeException("Illegal action!");
    }

}
