package com.telconova.supportsuite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo";
    }
}