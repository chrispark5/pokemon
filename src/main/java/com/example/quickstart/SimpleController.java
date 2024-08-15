package com.example.quickstart;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SimpleController {

    @GetMapping("/")
    public String index() {
        return "Home Page";
    }

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World";
    }

}
