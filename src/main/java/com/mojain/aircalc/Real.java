package com.mojain.aircalc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * A real number.
 *
 * From the requirements:
 *
 *    "Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal
 *     places (or less if it causes no loss of precision)."
 *
 *  I'm choosing to interpret this as 10/15 places of precision over all, not _after_ the decimal point.
 */
public class Real {

    private static final int SCALE = 15;

    private final BigDecimal value;

    public Real(double value) {
        this.value = new BigDecimal(value, new MathContext(SCALE));
    }

    private Real(BigDecimal value) {
        this.value = value.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public double asDouble() {
        return value.doubleValue();
    }

    public String toString() {
        return value.setScale(10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }

    // delegate mathematical operations to underlying BigDecimal

    public Real add(Real augend) {
        return new Real(value.add(augend.value));
    }

    public Real subtract(Real subtrahend) {
        return new Real(value.subtract(subtrahend.value));
    }

    public Real multiply(Real multiplicand) {
        return new Real(value.multiply(multiplicand.value));
    }

    public Real divide(Real divisor) {
        return new Real(value.divide(divisor.value, SCALE, RoundingMode.HALF_UP));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Real)) return false;
        Real real = (Real) o;
        return value.equals(real.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
