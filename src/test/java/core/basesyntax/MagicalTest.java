package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicalTest {
    static Magical magic;

    @BeforeEach
    void setUp() {
        magic = new Magical();
    }

    @Test
    void incorrect_Input_Operation_Exception_Expected() {
        assertThrows(RuntimeException.class,
                () -> magic.calculate(0, 0, "c"));
    }

    @Test
    void NPE_exception_Expected() {
        assertThrows(NullPointerException.class,
                () -> magic.calculate(0, 0, null));
    }

    void
}