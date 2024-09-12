package core.basesyntax;

public class CalculatorImplementation implements Calculator {

    @Override
    public double calculate(double firstNum, double secondNum, char mathOperation) {
        switch (mathOperation) {
            case '+':
                return addition(firstNum, secondNum);
            case '-':
                return subtraction(firstNum, secondNum);
            case '/':
                return division(firstNum, secondNum);
            case '*':
                return multiplication(firstNum, secondNum);
            case '^':
                return raiseToPower(firstNum, secondNum);
            default:
                throw new RuntimeException("Wrong input. Please try again");
        }
    }

    private double addition(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    private double subtraction(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    private double division(double firstNum, double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return firstNum / secondNum;
    }

    private double multiplication(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    private double raiseToPower(double firstNum, double secondNum) {
        return Math.pow(firstNum, secondNum);
    }
}
