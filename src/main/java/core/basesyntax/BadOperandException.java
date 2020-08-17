package core.basesyntax;

public class BadOperandException extends Exception{
     private String description;

    public BadOperandException(String description) {
        super(description);
    }
}
