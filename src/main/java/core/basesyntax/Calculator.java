package core.basesyntax;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {
    private static final ScriptEngine JS_ENGINE = new ScriptEngineManager().getEngineByName("js");

    static double evaluate(String expression) {
        try {
            return Double.parseDouble(JS_ENGINE.eval(expression).toString());
        } catch (ScriptException e) {
            throw new RuntimeException("Evaluate error");
        }
    }
}
