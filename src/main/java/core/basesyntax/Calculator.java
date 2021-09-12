package core.basesyntax;

public interface Calculator {
    double calculate(char operation);

    double calculate(double firstNumber, double secondNumber, char operation);
}
