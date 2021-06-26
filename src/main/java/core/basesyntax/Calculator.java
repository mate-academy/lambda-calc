package core.basesyntax;

interface Calculator {
    double calculate(String expression);

    double calculate(double a, double b, char charOfOperation);

    double add(double a, double b);

    double subtract(double a, double b);

    double divide(double a, double b);

    double multiply(double a, double b);

    double power(double a, double power);
}
