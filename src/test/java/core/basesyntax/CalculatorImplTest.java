package core.basesyntax;


import static java.lang.Double.NaN;


class CalculatorImplTest {
  private  double first;
  private  double second;
  private  char action;
  private  double actual;
  private double expected;
  private static final double delta = 0.0001;
  private static  Calculator calculator;
  private static final double MAX_VALUE = Double.MAX_VALUE;
  private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
  private static final double MIN_VALUE = Double.MIN_VALUE;

    @BeforeAll
    static void createCalculatorInstance() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_positive_numbersOk() {
        first = 5;
        second = 7;
        expected = 12;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void addition_oneNegative_numberOk() {
        first = 8;
        second = -5;
        expected = 3;
        action = '+';
        actual = calculator.calculate(first,second,action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addition_twoNegativeNumsOk() {
        first = -7;
        second = -16;
        expected = -23;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void addition_zeroNumOk() {
        first = 41;
        second = 0;
        expected = 41;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addition_floatingPointNumsOk() {
        first = 28.4;
        second = 35.8;
        expected = 64.2;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta);
        assertEquals(expected, calculator.calculate(second, first, action), delta);
        assertEquals(24.3, calculator.calculate(-12.1, 36.4, action), delta);
    }

    @Test
    void addition_positive_maxValuesOk() {
        first = MAX_VALUE;
        second = 741.5;
        expected = MAX_VALUE;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void addiction_maxAndMinValuesOk() {
        first = MAX_VALUE;
        second = -232157;
        expected = 1.7976931348623157E308;
        action = '+';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
        assertEquals(1.0E-323, calculator.calculate(MIN_VALUE, MIN_VALUE, action));
    }

    @Test
    void infinityTestOk() {
        first = MAX_VALUE;
        second = MAX_VALUE;
        action = '+';
        expected = POSITIVE_INFINITY;
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void defaultChar_actionNotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(13, 28, '\u0000'));
    }

    @Test
    void subtraction_twoPositiveNumsOk() {
        first = 43;
        second = 28;
        expected = 15;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_twoNegativeNumsOk() {
        first = -32;
        second = -21;
        expected = -11;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_oneNegativeNumOk() {
        first = -53;
        second = 23;
        expected = -76;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(76, calculator.calculate(second, first, action));
    }

    @Test
    void subtraction_zeroNumOk() {
        first = 0;
        second = 38;
        expected = -38;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(38, calculator.calculate(second, first, action));
    }

    @Test
    void subtraction_floatingPointNumsOk() {
        first = 33.4;
        second = 45.6;
        expected = -12.2;
        action = '-';
        actual = calculator.calculate(first, second,action);
        assertEquals(expected, actual, delta);
        assertEquals(12.2, calculator.calculate(second, first, action), delta);
    }

    @Test
    void subtraction_minValuesOk() {
        first = MIN_VALUE;
        second = MIN_VALUE;
        expected = 0;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_oneMinValuesOk() {
        first = MIN_VALUE;
        second = 543.4;
        expected = -543.4;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta);
        assertEquals(543.4, calculator.calculate(second, first, action), delta);

    }

    @Test
    void subtraction_MaxValuesOk() {
        first = MAX_VALUE;
        second = MAX_VALUE;
        expected = 0;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_oneMaxValueOk() {
        first = MAX_VALUE;
        second = 21345;
        expected = 1.7976931348623157E308;
        action = '-';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(-1.7976931348623157E308, calculator.calculate(second, first,action));
    }

    @Test
    void multiply_positiveNumsOk() {
        first = 4;
        second = 8;
        expected = 32;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected , calculator.calculate(second, first, action));
    }

    @Test
    void multiply_negativeNumsOk() {
        first = -4;
        second = -6;
        expected = 24;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void multiply_oneNegativeNumOk() {
        first = -6;
        second = 10;
        expected = -60;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
    }

    @Test
    void multiply_byZeroOk() {
        first = 24;
        second = 0;
        expected = 0;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
        assertEquals(expected, calculator.calculate(-first, second, action));
    }

    @Test
    void multiply_maxValueByOneOk() {
        first = MAX_VALUE;
        second = 1;
        expected = MAX_VALUE;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(second, first, action));
        assertEquals(-expected, calculator.calculate(first, -second, action));
    }

    @Test
    void multiply_maxValueOk() {
        first = MAX_VALUE;
        second = MAX_VALUE;
        expected = POSITIVE_INFINITY;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, calculator.calculate(first, second, action));
        assertEquals(-expected, calculator.calculate(first, -second, action));
        assertEquals(expected, calculator.calculate(first, 48, action));
    }

    @Test
    void multiply_minValuesOk() {
        first = MIN_VALUE;
        second = MIN_VALUE;
        expected = 0;
        action = '*';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(first, -second, action));
        assertEquals(1.14E-322, calculator.calculate(first, 23, action));
        assertEquals(1.14E-322, calculator.calculate(23, second, action));
        assertEquals(-1.14E-322, calculator.calculate(-23, second, action));
    }

    @Test
    void multiply_floatingPointNumbersOk() {
        first = 38.4;
        second = 4.6;
        expected = 176.64;
        action = '*';
        actual = calculator.calculate(first, second,action);
        assertEquals(expected, actual, delta);
        assertEquals(-expected, calculator.calculate(-first, second, action), delta);
    }

    @Test
    void nan_valuesNotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(NaN, NaN, action));
    }

    @Test
    void division_positiveNumsOk() {
        first = 9;
        second = 3;
        expected = 3;
        action = '/';
        actual = calculator.calculate(first, second ,action);
        assertEquals(expected, actual);
        assertEquals(0.3333333333333333, calculator.calculate(second, first, action), delta);
    }

    @Test
    void division_byZeroNotOk() {
        action = '/';
        assertThrows(ArithmeticException.class, () -> calculator.calculate(4, 0, action));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 4, action));
    }

    @Test
    void division_negativeNumsOk() {
        first = -5;
        second = -4;
        expected = 1.25;
        action = '/';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_oneNegitiveNumOk() {
        first = 32;
        second = -8;
        expected = -4;
        action = '/';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(-0.25, calculator.calculate(second, first, action), delta);
    }

    @Test
    void division_floatingPointNumsOk() {
        first = 28.4;
        second = 5.7;
        expected = 4.982456140350877;
        action = '/';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta);
    }

    @Test
    void division_MaxNumsOk() {
        first = MAX_VALUE;
        second = MAX_VALUE;
        expected = 1;
        action = '/';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(2.9482228625220422E-307, calculator.calculate(53, MAX_VALUE,action), delta);
        assertEquals(-2.9482228625220422E-307, calculator.calculate(53, -second, action), delta);
    }

    @Test
    void division_minValueOk() {
        first = 48;
        second = MIN_VALUE;
        expected = POSITIVE_INFINITY;
        action = '/';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(-expected, calculator.calculate(-first, second, action));
        assertEquals(0, calculator.calculate(second, first, action));
        assertEquals(0, calculator.calculate(second, -first, action));
    }

    @Test
    void raisingToAPower_NegativePowerOk() {
        first = 4;
        second = -3;
        expected = 0.015625;
        action = '^';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual, delta);
        assertEquals(-0.015625, calculator.calculate(-first, second, action), delta);
    }

    @Test
    void raisingToPower_PositivePowerOk() {
        first = -3;
        second = 5;
        expected = -243;
        action = '^';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(-expected, calculator.calculate(-first, second, action));
    }

    @Test
    void infinityValuesNotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(POSITIVE_INFINITY, POSITIVE_INFINITY, '/'));
    }

    @Test
    void raisingToPower_zeroToPowerOk() {
        first = 0;
        second = 12;
        expected = 0;
        action = '^';
        actual = calculator.calculate(first, second,action);
        assertEquals(expected, actual);
        assertEquals(POSITIVE_INFINITY, calculator.calculate(first, -second, action));
    }

    @Test
    void raisingToPower_zeroPowerOk() {
        first = 80;
        second = 0;
        expected = 1;
        action = '^';
        actual = calculator.calculate(first, second, action);
        assertEquals(expected, actual);
        assertEquals(expected, calculator.calculate(-first, second, action));
        
    }


}