package core.basesyntax;

public interface Calculator {
    double calculate(char action);

    double calculate(double firstNumber, double secondNumber, char action);
}
