package core.basesyntax;

public class TooBigValuesException extends RuntimeException {
    TooBigValuesException() {
        super();
    }

    TooBigValuesException(String message) {
        super(message);
    }
}
