package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;

public class Divides implements Operator {
    @Override
    public Real evaluate(Real... operands) {
        if (operands.length != 2) {
            throw new IllegalArgumentException("Divides operator takes exactly two operands");
        }
        return operands[1].divide(operands[0]);
    }

    public String toString() { return "/"; }
}
