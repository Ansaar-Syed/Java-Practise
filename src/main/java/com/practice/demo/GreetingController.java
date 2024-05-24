package com.practice.demo;

import com.practice.model.Request;
import com.practice.model.Response;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private long id = 0;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(id, String.format(template, name));
    }

    @PostMapping("/greeting")
    public Response greetingPost(@RequestBody Request request) {
        String greetingMessage = String.format(template, request.getName());
        return new Response(greetingMessage, ++id);
    }
}
