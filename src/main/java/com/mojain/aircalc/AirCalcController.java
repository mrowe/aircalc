package com.mojain.aircalc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirCalcController {

    @RequestMapping("/calc")
    public Greeting calc(@RequestParam(value = "name", defaultValue = "Foo") String name) {
        return new Greeting(1, String.format("Hello, %s!", name));
    }

}

class Greeting {

    public final long id;
    public final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}