package com.mojain.aircalc;

import org.springframework.web.bind.annotation.*;

@RestController
public class AirCalcController {

    @RequestMapping("/calc")
    public Greeting calc(@RequestParam(value = "name", defaultValue = "Foo") String name) {
        return new Greeting(1, String.format("Hello, %s!", name));
    }

}

class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}