package core.basesyntax;

import core.basesyntax.operators.Divide;
import core.basesyntax.operators.Minus;
import core.basesyntax.operators.Multiply;
import core.basesyntax.operators.Operators;
import core.basesyntax.operators.Pow;
import core.basesyntax.operators.Sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static Map<Character, Operators> map = new HashMap<>();

    static {
        map.put('+', new Sum());
        map.put('-', new Minus());
        map.put('*', new Multiply());
        map.put('/', new Divide());
        map.put(('^'), new Pow());
    }

    public static String lambdaImpl(Integer a, Character o, Integer b) {
        Operators operators = map.get(o);
        return operators.compute(a, b);
    }

    public static String calculating(Computation computation, Integer a, Character o, Integer b) {
        return computation.calculate(a, o, b);
    }

    public static void main(String[] args) {
        while (true) {
            Optional<Integer> firstOperand = InputOutputController.inputOperand();
            while (firstOperand.isEmpty()) {
                firstOperand = InputOutputController.inputOperand();
            }
            Integer firstNumber = firstOperand.get();

            Optional<Character> optionalOfOperation = InputOutputController.inputOperation();
            while (optionalOfOperation.isEmpty()) {
                optionalOfOperation = InputOutputController.inputOperation();
            }
            Character operation = optionalOfOperation.get();

            Optional<Integer> secondOperand = InputOutputController.inputOperand();
            while (secondOperand.isEmpty()) {
                secondOperand = InputOutputController.inputOperand();
            }
            Integer secondNumber = secondOperand.get();

            String result = calculating(Main::lambdaImpl, firstNumber, operation, secondNumber);

            System.out.println("Result = " + result + "\n");
        }
    }
}
