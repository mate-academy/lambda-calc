package core.basesyntax;

public class BadOperandException extends RuntimeException {

    public BadOperandException(String description) {
        super(description);
    }
}
