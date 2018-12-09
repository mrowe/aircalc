package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;

public class SquareRoot implements Operator {

    @Override
    public Real evaluate(Real... operands) {
        if (operands.length != 1) {
            throw new IllegalArgumentException("SquareRoot operator takes exactly one argument");
        }
        return new Real(Math.sqrt(operands[0].asDouble()));
    }

    public String toString() { return "√"; }
}
