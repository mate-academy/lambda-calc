package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POW = '^';
    private static final Map<Character, Action> ACTIONS = new HashMap<>();

    public Calculator() {
        ACTIONS.put(ADDITION, new Addition());
        ACTIONS.put(SUBTRACTION, new Subtraction());
        ACTIONS.put(DIVISION, new Division());
        ACTIONS.put(MULTIPLICATION, new Multiplication());
        ACTIONS.put(POW, new Pow());
    }

    public int calculate(int arg1, int arg2, char operation) {
        Action action = ACTIONS.get(operation);

        if (action == null) {
            throw new IllegalArgumentException("Wrong operation");
        }

        return action.execute(arg1, arg2);
    }

}
