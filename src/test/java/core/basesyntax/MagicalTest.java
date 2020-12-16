package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MagicalTest {
    private static Magical magic;
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int MIN_VALUE = Integer.MIN_VALUE;

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
    void divide_max_positives_Ok() {
        Assertions.assertEquals((double) MAX_VALUE / MAX_VALUE,
                magic.calculate(MAX_VALUE, MAX_VALUE, "/"));
    }

    @Test
    void divide_min_negatives_Ok() {
        Assertions.assertEquals((double) MIN_VALUE / MIN_VALUE,
                magic.calculate(MIN_VALUE, MIN_VALUE, "/"));
    }

    @Test
    void add_max_positive_Ok() {
        Assertions.assertEquals((double) MAX_VALUE + MAX_VALUE,
                magic.calculate(MAX_VALUE, MAX_VALUE, "+"));
    }

    @Test
    void add_max_positive_NotOk() {
        Assertions.assertNotEquals(MAX_VALUE + MAX_VALUE,
                magic.calculate(MAX_VALUE, MAX_VALUE, "+"));
    }

    @Test
    void add_min_negative_Ok() {
        Assertions.assertEquals((double) MIN_VALUE + MIN_VALUE,
                magic.calculate(MIN_VALUE, MIN_VALUE, "+"));
    }

    @Test
    void add_min_NotOk() {
        Assertions.assertNotEquals(MIN_VALUE + MIN_VALUE,
                magic.calculate(MIN_VALUE, MIN_VALUE, "+"));
    }

    @Test
    void add_negative_Ok() {
        Assertions.assertEquals((double) MAX_VALUE + MIN_VALUE,
                magic.calculate(MAX_VALUE, MIN_VALUE, "+"));
    }

    @Test
    void subtract_max_positive_Ok() {
        Assertions.assertEquals((double) MAX_VALUE - MAX_VALUE,
                magic.calculate(MAX_VALUE, MAX_VALUE, "-"));
    }

    @Test
    void subtract_min_negative_Ok() {
        Assertions.assertEquals((double) MIN_VALUE - MIN_VALUE,
                magic.calculate(MAX_VALUE, MAX_VALUE, "-"));
    }
}