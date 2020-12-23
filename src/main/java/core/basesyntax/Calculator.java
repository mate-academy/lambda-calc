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
            return raisingToAPower(firstNum, secondNum);
        }
        throw new ArithmeticException("Wrong operator");
    }

    private static double raisingToAPower(double firstNum, double secondNum) {
        double result = 1;
        if (secondNum == 0) {
            return 1;
        }
        for (int i = 0; i < Math.abs(secondNum); i++) {
            result *= firstNum;
        }
        return (secondNum > 0) ? result : 1 / result;
    }

    private static void checkForZero(double secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("Can't divide by zero!");
        }
    }
}
