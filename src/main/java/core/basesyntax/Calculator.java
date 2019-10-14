package core.basesyntax;

import core.basesyntax.operators.Divide;
import core.basesyntax.operators.Minus;
import core.basesyntax.operators.Multiply;
import core.basesyntax.operators.Operators;
import core.basesyntax.operators.Pow;
import core.basesyntax.operators.Sum;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<Character, Operators> map = new HashMap<>();

    static {
        map.put('+', new Sum());
        map.put('-', new Minus());
        map.put('*', new Multiply());
        map.put('/', new Divide());
        map.put(('^'), new Pow());
    }

    public static int lambdaImpl(int a, Character o, int b) {
        Operators operators = map.get(o);
        return operators.compute(a, b);
    }

    public static int calculating(Computation computation, int a, Character o, int b) {
        return computation.calculate(a, o, b);
    }
}
