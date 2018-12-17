package com.mojain.aircalc.commands;

import com.mojain.aircalc.Real;
import com.mojain.aircalc.Stack;
import com.mojain.aircalc.operators.Plus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UndoTest {

    @Test
    public void shouldUndoLastPush() {
        Stack stack = new Stack();
        (new Push(new Real(1))).invoke(stack);
        (new Push(new Real(2))).invoke(stack);
        (new Undo()).invoke(stack);
        assertEquals(1, stack.size());
        assertEquals(new Real(1), stack.peek());
    }

    @Test
    public void shouldUndoLastEval() {
        Stack stack = new Stack();
        (new Push(new Real(1))).invoke(stack);
        (new Push(new Real(2))).invoke(stack);
        (new Eval(new Plus(3))).invoke(stack);
        (new Undo()).invoke(stack);
        assertEquals(2, stack.size());
        assertEquals(new Real(2), stack.peek());
    }

    @Test
    public void equals() {
        Undo a = new Undo();
        Undo b = new Undo();
        assertEquals(a, b);
    }
}