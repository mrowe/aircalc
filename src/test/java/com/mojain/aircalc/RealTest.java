package com.mojain.aircalc;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RealTest {

    @Test
    public void shouldStoreAValue(){
        assertEquals(123.0, new Real(123.0).asDouble(), 0.0);
    }

    @Test
    public void shouldStoreAtLeast15DigitsOfPrecision() {
        assertEquals(0.0123456789123456, new Real(0.0123456789123456).asDouble(), 0);
    }

    @Test
    public void shouldMaintainPrecisionAcrossOperations() {
        Real real = new Real(2.0);
        assertRealEquals(2.0, real.divide(new Real(2.0)).multiply(new Real(2.0)));
    }

    @Test
    public void shouldHandleRepeatingDecimals() {
        Real real = new Real(1.0);
        assertRealEquals(0.333333333333333, real.divide(new Real(3.0)));
    }

    @Test
    public void shouldBeAbleToAdd() {
        assertRealEquals(3.0, new Real(1).add(new Real(2)));
    }

    @Test
    public void shouldBeAbleToSubtract() {
        assertRealEquals(1.0, new Real(3).subtract(new Real(2)));
    }

    @Test
    public void shouldCompareValues() {
        assertEquals(new Real(1), new Real(1));
    }

    @Test
    public void shouldCompareWithinPrecisionDelta() {
        assertEquals(new Real(1.0000000000000001), new Real(1.0000000000000002));
    }

    @Test
    public void shouldCompareUnequalValues() {
        assertNotEquals(new Real(1), new Real(2));
    }

    @Test
    public void shouldHandleIncompatibleTypeComparisons() {
        assertNotEquals(new BigDecimal(1), new Real(1));
    }

    @Test
    public void shouldHandleNullComparisons() {
        assertNotEquals(null, new Real(1));
    }

    @Test
    public void shouldFormatIntegerWithoutDecimals() {
        Real real = new Real(123.0);
        assertEquals("123", real.toString());
    }

    @Test
    public void shouldFormatDecimalWithSufficientPrecision() {
        assertEquals("1.23", new Real(1.23).toString());
    }

    @Test
    public void shouldFormatDecimalWithSufficientPrecision1() {
        assertEquals("12.3", new Real(12.3).toString());
    }

    @Test
    public void shouldFormatDecimalWithoutExcessivePrecision() {
        assertEquals("0.0123456789", new Real(0.012345678912345).toString());
    }

    private void assertRealEquals(double expected, Real actual) {
        assertEquals(expected, actual.asDouble(), 0.000000000000001);
    }
}