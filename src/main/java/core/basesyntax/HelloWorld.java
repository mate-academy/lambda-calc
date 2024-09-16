package core.basesyntax;

public class HelloWorld {
    public double calculate(double firstNum, double secondNum, char operation) {
        switch (operation) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                if (secondNum == 0) {
                    throw new IllegalArgumentException("Divisor can't be zero");
                }
                return firstNum / secondNum;
            case '^':
                return Math.pow(firstNum, secondNum);
            default:
                throw new IllegalArgumentException();
        }
    }
}
