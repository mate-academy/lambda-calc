package core.basesyntax;

public class Calculator implements Calc {

    public double calculate(double firstOperand, double secondOperand, char operation) {
        if (operation == '+') {
            return firstOperand + secondOperand;
        }

        if (operation == '-') {
            return firstOperand - secondOperand;
        }

        if (operation == '/') {
            return firstOperand / secondOperand;
        }

        if (operation == '*') {
            return firstOperand * secondOperand;
        }

        if (operation == '^') {
            double result = 1;
            for (int i = 1; i <= secondOperand; i++) {
                result = result * firstOperand;
            }
            return result;
        }
        return 0;
    }
}
