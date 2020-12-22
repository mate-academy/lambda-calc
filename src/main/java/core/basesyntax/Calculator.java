package core.basesyntax;

public class Calculator {

    public double calculator(int a, int b, char operator) {
        if (operator == '+') {
            return (double) a + b;
        }
        if (operator == '-') {
            return (double) a - b;
        }
        if (operator == '*') {
            return a * b;
        }
        if (operator == '/') {
            if (b == 0) {
                throw new ArithmeticException("Can't division on zero!");
            }
            return (double) a / b;
        }
        double retValue = a;
        int counter = 0;
        if (b < 0) {
            counter = b * (-1);
        }
        for (int i = 1; i < counter; i++) {
            retValue *= a;
        }
        if (b < 0) {
            retValue = 1 / retValue;
        }
        if (b == 0) {
            retValue = 1;
        }
        return retValue;
    }
}
