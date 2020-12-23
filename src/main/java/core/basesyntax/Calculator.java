package core.basesyntax;

public class Calculator {
    private Double firstNumber;
    private Double secondNumber;

    public Calculator() {
    }

    public Calculator(Double firstNumber, Double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public boolean checkForNull() {
        if (firstNumber == null || secondNumber == null) {
            throw new NullPointerException();
        }
        return true;
    }
    
    public double calculate(Double firstNumber, Double secondNumber, char operations) {
        checkForNull();
        switch (operations) {
            case '+' :
                return firstNumber + secondNumber;
            case '-' :
                return firstNumber - secondNumber;
            case '*' :
                return firstNumber * secondNumber;
            case '/' :
                if (secondNumber == 0) {
                    throw new ArithmeticException("Divide to zero");
                }
                return firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default :
                return 0;
        }
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public boolean setFirstNumber(Double firstNumber) {
        if (firstNumber == null) {
            throw new NullPointerException();
        }
        this.firstNumber = firstNumber;
        return true;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public boolean setSecondNumber(Double secondNumber) {
        if (secondNumber == null) {
            throw new NullPointerException();
        }
        this.secondNumber = secondNumber;
        return true;
    }
}
