package core.basesyntax;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class CalculatorImpl {

    private static final HashMap<String, DoubleBinaryOperator> calculator;

    static {
        calculator = new HashMap<>();
        calculator.put("+", Double::sum);
        calculator.put("-", (a, b) -> a - b);
        calculator.put("*", (a, b) -> a * b);
        calculator.put("/", (a, b) -> a / b);
    }

    public double executor(String[] args) {
        return ((Double.parseDouble(args[0]) == 0 || Double.parseDouble(args[2]) == 0)
                && (args[1].equals("*") || args[1].equals("/"))) ? 0
                : calculator.get(args[1])
                .applyAsDouble(Double.parseDouble(args[0]), Double.parseDouble(args[2]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arguments = scanner.nextLine().split(" ");
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println(calculator.executor(arguments));

    }
}
