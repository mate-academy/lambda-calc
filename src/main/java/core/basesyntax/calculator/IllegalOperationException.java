package core.basesyntax.calculator;

public class IllegalOperationException extends RuntimeException {
    public IllegalOperationException(String errorMassage) {
        super(errorMassage);
    }
}
