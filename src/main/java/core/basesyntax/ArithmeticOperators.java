package core.basesyntax;

public enum ArithmeticOperators {
    ADDITION('+'),
    SUBTRACTION('-'),
    DIVISION('/'),
    MULTIPLICATION('*'),
    RISING_TO_POWER('^');

    private Character character;

    ArithmeticOperators(Character character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
