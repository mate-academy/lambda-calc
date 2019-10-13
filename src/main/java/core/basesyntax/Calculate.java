package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculate {
    private char operation;
    private double firstNumber;
    private double secondNumber;
    private static final BiFunction<Double, Double, Double> SUM
            = (firstNumber, secondNumber) -> firstNumber + secondNumber;
    private static final BiFunction<Double, Double, Double> SUB
            = (firstNumber, secondNumber) -> firstNumber - secondNumber;
    private static final BiFunction<Double, Double, Double> MUL
            = (firstNumber, secondNumber) -> firstNumber * secondNumber;
    private static final BiFunction<Double, Double, Double> POW
            = (firstNumber, secondNumber) -> Math.pow(firstNumber, secondNumber);
    private static Map<Character, BiFunction<Double, Double, Double>> map;

    static {
        map = new HashMap<>();
        map.put('+', SUM);
        map.put('-', SUB);
        map.put('*', MUL);
        map.put('/', Calculate::div);
        map.put('^', POW);
    }

    public Calculate(double firstNumber, char operation, double secondNumber) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    private static double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero!");
        }
        return a / b;
    }

    Double result() {
        return map.get(operation).apply(firstNumber, secondNumber);
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate(6, '^', 0);
        System.out.println(calculate.result());
    }
}
