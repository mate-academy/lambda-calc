package core.basesyntax;

public class Calculator {

    public int operate(int a, int b, Operation operation) {
        return operation.operation(a, b);
    }

    private static Operation addition = ((number1, number2) -> number1 + number2);
    private static Operation subtraction = (number1, number2) -> number1 - number2;
    private static Operation multiplication = (number1, number2) -> number1 * number2;
    private static Operation division = (number1, number2) -> number1 / number2;

    public int add(int a, int b) {
        return operate(a, b, addition);
    }

    public int subtract(int a, int b) {
        return operate(a, b, subtraction);
    }

    public int multiply(int a, int b) {
        return operate(a, b, multiplication);
    }

    public int divide(int a, int b) {
        return operate(a, b, division);
    }

}

