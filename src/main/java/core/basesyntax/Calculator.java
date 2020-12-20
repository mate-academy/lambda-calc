package core.basesyntax;

public class Calculator {
    private Integer firstNumber;
    private Integer secondNumber;

    public boolean checkForNull() {
        if (firstNumber == null || secondNumber == null) {
            throw new NullPointerException();
        }
        return true;
    }

    public Integer addition(Integer a, Integer b) {
        checkForNull();
        return a + b;
    }

    public Integer subtraction(Integer a, Integer b) {
        checkForNull();
        return a - b;
    }

    public Integer division(Integer a, Integer b) {
        checkForNull();
        if (b == 0) {
            throw new ArithmeticException("You can't divide the number by zero");
        }
        return a / b;
    }

    public Integer multiplication(Integer a, Integer b) {
        checkForNull();
        return a * b;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public boolean setFirstNumber(Integer firstNumber) {
        if (firstNumber == null) {
            throw new NullPointerException();
        }
        this.firstNumber = firstNumber;
        return true;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public boolean setSecondNumber(Integer secondNumber) {
        if (secondNumber == null) {
            throw new NullPointerException();
        }
        this.secondNumber = secondNumber;
        return true;
    }
}
