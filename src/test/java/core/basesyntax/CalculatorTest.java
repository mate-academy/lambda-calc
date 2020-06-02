package core.basesyntax;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private static final char POW = '^';
    private static final char UNSUPPORTED = '@';
    private static final double ONE = 1.0;
    private static final double ZERO = 0.0;
    private static final double NOT_A_NUMBER = Double.NaN;
    private static final double POS_INFINITY = Double.POSITIVE_INFINITY;
    private static final double NEG_INFINITY = Double.NEGATIVE_INFINITY;
    private static final double[] ADD_EXPECTED =
            new double[] {2., 110., 3000., 0., -13., 4.9};
    private static final double[] SUB_EXPECTED =
            new double[] {0., -20., -1000., 1., 7., -5.1};
    private static final double[] MUL_EXPECTED =
            new double[] {1., 2925., 2000000., -0.25, 30., -0.5};
    private static final double[] DIV_EXPECTED =
            new double[] {1., 0.6923076923076923, 0.5, -1., 0.3, -0.02};
    private static final double[] POW_EXPECTED =
            new double[] {2.5, 234.09000000000003, 6.25E-6, 1.0, 81.0, -3.200000000000001E-4};
    private static Calculator calculator;

    @BeforeAll
    static void initBeforeAll() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "#{index}: {0} + {1}")
    @MethodSource(value = "inputProvider")
    @DisplayName(value = "Testing addition with enum")
    void calculateAdditionEqual(double left, double right, int index) {
        assertEquals(ADD_EXPECTED[index], calculator.calculate(left, right, ADD),
                "The '+' symbol should perform addition between two numbers");
    }

    @ParameterizedTest(name = "#{index}: {0} - {1}")
    @MethodSource(value = "inputProvider")
    @DisplayName(value = "Testing subtraction with enum")
    void calculateSubtractionEqual(double left, double right, int index) {
        assertEquals(SUB_EXPECTED[index], calculator.calculate(left, right, SUB),
                "The '-' symbol should perform subtraction between two numbers");
    }

    @ParameterizedTest(name = "#{index}: {0} * {1}")
    @MethodSource(value = "inputProvider")
    @DisplayName(value = "Testing multiplication with enum")
    void calculateMultiplicationEqual(double left, double right, int index) {
        assertEquals(MUL_EXPECTED[index], calculator.calculate(left, right, MUL),
                "The '*' symbol should perform multiplication between two numbers");
    }

    @ParameterizedTest(name = "#{index}: {0} / {1}")
    @MethodSource(value = "inputProvider")
    @DisplayName(value = "Testing division with enum")
    void calculateDivisionEqual(double left, double right, int index) {
        assertEquals(DIV_EXPECTED[index], calculator.calculate(left, right, DIV),
                "The '/' symbol should perform division between two numbers");
    }

    @Test
    @DisplayName(value = "Testing division by zero cases with enum")
    void calculateDivisionByZero() {
        assertAll(
                () -> assertDoesNotThrow(() -> calculator.calculate(1, 0, DIV),
                "Division by zero shouldn't throw exception"),
                () -> assertEquals(POS_INFINITY,
                calculator.calculate(ONE, ZERO, DIV),
                "Dividing a positive number by zero should return positive infinity"),
                () -> assertEquals(NEG_INFINITY, calculator.calculate(-ONE, ZERO, DIV),
                "Dividing a negative number by zero should return negative infinity"),
                () -> assertEquals(NOT_A_NUMBER, calculator.calculate(ZERO, ZERO, DIV),
                "Dividing zero by zero should return NaN")
        );
    }

    @ParameterizedTest(name = "#{index}: pow({0}, {1})")
    @MethodSource(value = "inputProviderExponent")
    @DisplayName(value = "Testing exponentiation with enum")
    void calculateExponentiationEqual(double left, double right, int index) {
        String message = "The '^' symbol should perform exponentiation";
        assertEquals(POW_EXPECTED[index],
                calculator.calculate(left, right, POW), message);
    }

    @Test
    @DisplayName(value = "Testing unsupported operator")
    void calculateThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(ONE, ZERO, UNSUPPORTED));
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                arguments(1., 1., 0),
                arguments(45., 65., 1),
                arguments(1000., 2000., 2),
                arguments(0.5, -0.5, 3),
                arguments(-3., -10., 4),
                arguments(-0.1, 5., 5)
        );
    }

    static Stream<Arguments> inputProviderExponent() {
        return Stream.of(
                arguments(2.5, 1., 0),
                arguments(15.3, 2., 1),
                arguments(400., -2., 2),
                arguments(1., -4., 3),
                arguments(-3., 4., 4),
                arguments(-0.2, 5., 5)
        );
    }
}
