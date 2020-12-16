package core.basesyntax;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicalTest {
    static Magical magic;
    @BeforeAll
    static void beforeAll() {
        magic = new Magical();
    }

    @Test
    void incorrectInputOperationExceptionExpected() {
        try {
            magic.calculate(0, 0, 'c');
        } catch (RuntimeException e) {
            return;
        }
        fail("RuntimeException is expected with incorrect input");
    }
}