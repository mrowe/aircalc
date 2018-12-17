package com.mojain.aircalc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    private Stack stack;
    private Real item;

    @Before
    public void setUp() {
        stack = new Stack();
        item = new Real(1);
    }

    @Test
    public void push() {
        stack.push(item);
        assertEquals(item, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void peek() {
        stack.push(item);
        assertEquals(item, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void pop() {
        stack.push(item);
        assertEquals(item, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void size() {
        assertEquals(0, stack.size());
        stack.push(item);
        assertEquals(1, stack.size());
    }

    @Test
    public void clear() {
        stack.push(item);
        stack.clear();
        assertEquals(0, stack.size());
    }

    @Test
    public void commit() {
        stack.push(item);
        stack.checkpoint();
        stack.push(new Real(2));
        stack.push(new Real(3));
        stack.undo();
        assertEquals(1, stack.size());
        assertEquals(item, stack.pop());
    }

    @Test
    public void undo() {
        stack.push(item);
        stack.undo();
        assertEquals(0, stack.size());
    }

    @Test
    public void undoTwoOperations() {
        stack.push(item);
        stack.checkpoint();
        stack.push(item);
        assertEquals(2, stack.size());
        stack.undo();
        assertEquals(1, stack.size());
        stack.undo();
        assertEquals(0, stack.size());
    }
}