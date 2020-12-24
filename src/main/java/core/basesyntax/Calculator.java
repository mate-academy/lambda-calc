package core.basesyntax;

public class Calculator implements Calculable {

    @Override
    public double calculate(double firstNum, double secondNum, double operator) {
        if (operator == '+') {
            return firstNum + secondNum;
        }
        if (operator == '-') {
            return firstNum - secondNum;
        }
        if (operator == '/') {
            checkForZero(secondNum);
            return (double) firstNum / secondNum;
        }
        if (operator == '*') {
            return firstNum * secondNum;
        }
        if (operator == '^') {
            if (firstNum == 0 && secondNum < 0) {
                throw new ArithmeticException("Can't raise zero to the negative power!");
            }
            return Math.pow(firstNum, secondNum);
        }
        throw new ArithmeticException("Wrong operator");
    }

    private static void checkForZero(double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("Can't divide by zero!");
        }
    }
}
