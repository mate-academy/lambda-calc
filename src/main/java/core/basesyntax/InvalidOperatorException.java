package core.basesyntax;

public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException() {
        super("There is no arithmetic operator like this");
    }
}
