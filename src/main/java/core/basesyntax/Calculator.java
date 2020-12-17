package core.basesyntax;

public class Calculator {
    private Integer result;
    private Integer firstNumber;
    private Integer secondNumber;

    public Calculator(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public boolean checkForNull() {
        if (firstNumber == null || secondNumber == null) {
            throw new NullPointerException();
        }
        return false;
    }

    public Integer addition(Integer a, Integer b) {
        result = a + b;
        return result;
    }

    public Integer subtraction(Integer a, Integer b) {
        result = a - b;
        return result;
    }

    public Integer division(Integer a, Integer b) {
        if (a < b && a != 0) {
            result = b / a;
            return result;
        }
        if (a > b && b != 0) {
            result = a / b;
            return result;
        }
        return 1;
    }

    public Integer multiplication(Integer a, Integer b) {
        result = a * b;
        return result;
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

    public Integer getResult() {
        return result;
    }

    public boolean setSecondNumber(Integer secondNumber) {
        if (secondNumber == null) {
            throw new NullPointerException();
        }
        this.secondNumber = secondNumber;
        return true;
    }
}
