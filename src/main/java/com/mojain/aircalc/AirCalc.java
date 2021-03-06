package com.mojain.aircalc;

import java.util.Scanner;

public class AirCalc {

    public static void main(String[] args) {
        System.out.println("Hello!");

        Stack stack = new Stack();
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);

        State state = State.RUNNING;
        while ((state == State.RUNNING && in.hasNext())) {
            int commandIndex = 0;
            for (Command command : parser.parse(in.nextLine())) {
                commandIndex++;
                try {
                    state = command.invoke(stack);
                } catch (InsufficientOperandsException e) {
                    System.err.format("operator %s (position: %d): insufficient parameters\n", e.getMessage(), commandIndex);
                    break;
                }
            }
            System.out.println(stack.toString());
        }
    }
}
