package core.basesyntax;

public interface Calculator {
    double calculate(String expression);

    double calculate(double a, double b, char charOfOperation);

    double add(double a, double b);

    double subtract(double a, double b);

    double div(double a, double b);

    double multiply(double a, double b);

    double pow(double a, double power);
}
