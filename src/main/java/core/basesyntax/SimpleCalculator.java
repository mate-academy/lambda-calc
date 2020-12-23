package core.basesyntax;

public class SimpleCalculator implements Calculator {
    @Override
    public double calculate(double first, double second, char operation) {
        Operation correspondingOperation = Operation.getOperation(String.valueOf(operation));
        return correspondingOperation.operation(first, second);
    }
}
