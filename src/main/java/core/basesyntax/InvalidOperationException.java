package core.basesyntax;

public class InvalidOperationException extends RuntimeException {
    InvalidOperationException() {
        super();
    }

    InvalidOperationException(String message) {
        super(message);
    }
}
