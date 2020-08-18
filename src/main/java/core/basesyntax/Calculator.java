package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Action action;
    private Map<Character, Action> map = new HashMap<>();

    public Calculator() {
        map.put('+', new Addition());
        map.put('-', new Subtraction());
        map.put('/', new Division());
        map.put('*', new Multiplication());
        map.put('^', new Power());
    }

    public double calculate(double a, double b, char actionSymbol) {
        action = map.get(actionSymbol);
        return action.doAction(a, b);
    }
}
