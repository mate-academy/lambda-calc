package core.basesyntax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MagicalTest {
    static Magical magic;

    @BeforeEach
    void setUp() {
        magic = new Magical();
    }

    @Test
    void assertThrowRuntimeException() {
        assertThrows(RuntimeException.class,
                () -> magic.calculate(0, 0, "c"));
    }

    @Test
    void assertThrowNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> magic.calculate(0, 0, null));
    }
}