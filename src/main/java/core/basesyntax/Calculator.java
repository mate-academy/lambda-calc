package core.basesyntax;

public class Calculator {

    public double calculate(double firstNum, char operand, double secondNum) {
        switch (operand) {
            case '+':
                return addition(firstNum, secondNum);
            case '-':
                return subtraction(firstNum, secondNum);
            case '/':
                return division(firstNum, secondNum);
            case '*':
                return multiplication(firstNum, secondNum);
            case '^':
                return raisingToThePower(firstNum, secondNum);
            default:
                throw new IllegalArgumentException("Sorry, illegal operand");
        }
    }

    public double addition(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    public double subtraction(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    public double division(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException("You can't divide by zero");
        }
        return firstNum / secondNum;
    }

    public double multiplication(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    public double raisingToThePower(double firstNum, double secondNum) {
        return Math.pow(firstNum, secondNum);
    }
}
