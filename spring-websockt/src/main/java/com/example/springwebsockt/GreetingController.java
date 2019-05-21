package com.example.springwebsockt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/spring-websocket")
public class GreetingController {
    @GetMapping(path = "")
    public String greeting() {
        return "hello world";
    }
}
