package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculateTest {
    private Calculate calculate;

    @Before
    public void setUp() {
        Calculate calculate = new Calculate();
    }

    @Test
    public void AdditionCheck() {
        Assert.assertEquals(BigDecimal.valueOf(52),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '+'));
        Assert.assertNotEquals(BigDecimal.valueOf(50),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '+'));
        Assert.assertEquals(BigDecimal.valueOf(Integer.MAX_VALUE)
                        .add(BigDecimal.valueOf(Integer.MAX_VALUE)),
                calculate.calculate(BigDecimal.valueOf(Integer.MAX_VALUE),
                        BigDecimal.valueOf(Integer.MAX_VALUE), '+'));
    }

    @Test
    public void SubtractionCheck() {
        Assert.assertEquals(BigDecimal.valueOf(48),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '-'));
        Assert.assertNotEquals(BigDecimal.valueOf(50),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '-'));
    }

    @Test
    public void DivisionCheck() {
        Assert.assertEquals(BigDecimal.valueOf(25),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '/'));
        Assert.assertNotEquals(BigDecimal.valueOf(50),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '/'));
    }

    @Test
    public void MultiplicationCheck() {
        Assert.assertEquals(BigDecimal.valueOf(100),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '*'));
        Assert.assertNotEquals(BigDecimal.valueOf(50),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '*'));
    }

    @Test
    public void PowerCheck() {
        Assert.assertEquals(BigDecimal.valueOf(2500),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '^'));
        Assert.assertNotEquals(BigDecimal.valueOf(50),
                calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void OperationCheck() {
        calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(2), '=');
        calculate.calculate(BigDecimal.valueOf(50), BigDecimal.valueOf(0), '/');
    }
}
