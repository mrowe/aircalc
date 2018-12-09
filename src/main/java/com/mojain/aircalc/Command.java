package com.mojain.aircalc;

import java.util.Stack;

public interface Command {
    State invoke(Stack<Real> stack);
}
