package core.basesyntax;

public class Calculator {
    double calculate(double value1, double value2, char operation) {
        switch (operation) {
            case '+' :
                return value1 + value2;
            case '-' :
                return value1 - value2;
            case '*' :
                return value1 * value2;
            case '/' :
                if (value2 == 0) {
                    throw new ArithmeticException("Division by 0 is not possible");
                }
                return value1 / value2;
            case '^' :
                return Math.pow(value1, value2);
            default:
                throw new RuntimeException("Operation is wrong" + operation);
        }
    }
}
