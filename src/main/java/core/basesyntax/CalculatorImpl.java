package core.basesyntax;

import service.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(double firstParam, double secondParam, char operation) {
        switch (operation) {
            case '+':
                return firstParam + secondParam;
            case '-':
                return firstParam - secondParam;
            case '/':
                if (secondParam == 0) {
                    throw new ArithmeticException("Can't divide by 0.");
                }
                return firstParam / secondParam;
            case '*':
                return (firstParam == 0 || secondParam == 0) ? 0 : firstParam * secondParam;
            case '^':
                return Math.pow(firstParam, secondParam);
            default:
                throw new RuntimeException("Not valid input. "
                        + "Only digits and arithmetic operations (+, -, *, ^) are allowed.");
        }
    }
}
