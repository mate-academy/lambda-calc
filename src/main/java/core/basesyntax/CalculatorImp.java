package core.basesyntax;

public class CalculatorImp implements Calculator {
    @Override
    public double calculate(double number1, double number2, char operation) {
        if (operation == '+') {
            return number1 + number2;
        }
        if (operation == '-') {
            return number1 - number2;
        }
        if (operation == '/') {
            if (number2 == 0) {
                throw new ArithmeticException("Can`t divide by zero");
            }
            return number1 / number2;
        }
        if (operation == '*') {
            return number1 * number2;
        }
        if (operation == '^') {
            if (number1 < 0) {
                return Math.pow(number1 * -1, number2) * -1;
            }
            return Math.pow(number1, number2);
        }
        throw new IllegalArgumentException("Illegal argument " + operation);
    }
}
