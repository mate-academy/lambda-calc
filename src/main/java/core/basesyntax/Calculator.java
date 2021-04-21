package core.basesyntax;

public class Calculator {

    public double calculate(double a, double b, char operand) {
        if (operand == '+') {
            return a + b;
        }
        if (operand == '-') {
            return a - b;
        }
        if (operand == '*') {
            return a * b;
        }
        return 0.0;
    }
    /*
    Write a calculator. Method calculate() should accept three parameters: two values of type double
     and operation of type char. This method should be able to perform the following operations:

Addition
Subtraction
Division
Multiplication
raising to a power
     */
}
