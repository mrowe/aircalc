package com.mojain.aircalc;

public interface Operator {
    Real evaluate(Real... operands);
    int arity();
    int tokenNumber();
}
