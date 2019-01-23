package com.mojain.aircalc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirCalcController {

    @RequestMapping("/calc")
    public PrintableStack calc(@RequestParam(value = "commands", defaultValue = "") String commands) {
        Stack stack = new Stack();
        Parser parser = new Parser();

        int commandIndex = 0;
        for (Command command : parser.parse(commands)) {
            commandIndex++;
            try {
                command.invoke(stack);
            } catch (InsufficientOperandsException e) {
                System.err.format("operator %s (position: %d): insufficient parameters\n", e.getMessage(), commandIndex);
                break;
            }
        }

        return new PrintableStack(stack);
    }

}

class PrintableStack {

    public final String stack;

    public PrintableStack(Stack stack) {
        this.stack = stack.toString();
    }
}