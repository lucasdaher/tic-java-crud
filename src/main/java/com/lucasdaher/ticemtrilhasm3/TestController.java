package com.lucasdaher.ticemtrilhasm3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola-mundo")
public class TestController {

    @GetMapping
    public String pegaOlaMundo() {
        return "Olá mundo!";
    }
}
