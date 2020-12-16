package core.basesyntax;

import org.junit.jupiter.api.Assertions;
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
    void operation_input_NotOk() {
        assertThrows(RuntimeException.class,
                () -> magic.calculate(0, 0, "c"));
    }

    @Test
    void null_operation_input_NotOk() {
        assertThrows(NullPointerException.class,
                () -> magic.calculate(0, 0, null));
    }

    @Test
    void divide_by_zero_Ok() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> magic.calculate(5, 0, "/"));
    }
    @Test
    void add_Max_Values_Ok() {
        double first = Integer.MAX_VALUE;
        double second = Integer.MAX_VALUE;
        Assertions.assertEquals(first + second,
                magic.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, "+"));
    }
}