package core.basesyntax;

public class Calculator implements CalculatorInterface {
    public double calculate(double firstNum, double secondNum, char operator) {
        switch (operator) {
            case '+' :
                return firstNum + secondNum;
            case '-' :
                return firstNum - secondNum;
            case '/' :
                if (secondNum == 0) {
                    throw new ArithmeticException("Can't divide by 0");
                }
                return firstNum / secondNum;
            case '*' :
                return firstNum * secondNum;
            case '^' :
                return Math.pow(firstNum, secondNum);
            default:
                throw new IllegalArgumentException("Illegal operator");
        }
    }
}
