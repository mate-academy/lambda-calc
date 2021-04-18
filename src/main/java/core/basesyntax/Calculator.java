package core.basesyntax;

public class Calculator {
    private static final String CORRECT_OPERATION = "+-/*^";

    public double calculate(double firstArgument, double secondArgument, char operation) {
        checkOperation(operation);
        checkDivideByZero(secondArgument, operation);
        ICalculate calculate = (firstArg, secondArg) -> operation == '+' ? firstArg + secondArg
                : operation == '-' ? firstArg - secondArg
                : operation == '*' ? firstArg * secondArg
                : operation == '/' ? firstArg / secondArg
                : Math.pow(firstArg, secondArg);
        double calculated = calculate.calculate(firstArgument, secondArgument);
        checkInfinityNumber(calculated);
        return calculated;
    }

    private void checkInfinityNumber(double number) {
        if (number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("The number is [" + number + "]!");
        }
    }

    private void checkOperation(char operation) {
        if (CORRECT_OPERATION.indexOf(operation) < 0) {
            throw new IllegalArgumentException("No such operation [" + operation + "]!");
        }
    }

    private void checkDivideByZero(double argument, char operation) {
        if (argument == 0 && operation == '/') {
            throw new ArithmeticException(
                    "Division by zero because second argument is [" + argument + "]!");
        }
    }
}

