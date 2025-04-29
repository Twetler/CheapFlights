package com.backend.hellospringboot;

// Controllers
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Map;
import java.util.HashMap;

// Rest API's
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String, String> say_hi() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hey, your test has worked");
        return response;
    }
}


