package core.basesyntax;

public class Calculator {
    private double operate(Double a, Double b, CalculateAble calculateAble) {
        return calculateAble.operation(a, b);
    }

    private double addition(Double first, Double second) {
        CalculateAble addition = Double::sum;
        return operate(first, second, addition);
    }

    private double subtraction(Double first, Double second) {
        CalculateAble subtraction = (number1, number2) -> number1 - number2;
        return operate(first, second, subtraction);
    }

    private double multiplication(Double first, Double second) {
        CalculateAble multiplication = (number1, number2) -> number1 * number2;
        return operate(first, second, multiplication);
    }

    private double division(Double first, Double second) {
        CalculateAble division = (number1, number2) -> number1 / number2;
        return operate(first, second, division);
    }

    private double power(Double first, Double second) {
        CalculateAble power = Math::pow;
        return operate(first, second, power);
    }

    public static double calculate(Double first, Double second, Character operator) {
        Calculator calculator = new Calculator();
        return operator == '-' ? calculator.subtraction(first, second) :
                operator == '+' ? calculator.addition(first, second) :
                        operator == '/' ? calculator.division(first, second) :
                                operator == '*' ? calculator.multiplication(first, second) :
                                        operator == '^' ? calculator.power(first, second) :
                                                null;
    }
}
