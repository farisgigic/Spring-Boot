package com.example.demo.rest_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
    @GetMapping("/getName")
    public String sayHello(@RequestParam(value = "name", defaultValue = "world") String name){
        return "Hello, " + name;
    }


}
