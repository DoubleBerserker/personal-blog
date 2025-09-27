package com.DoubleBerserker.Personal.Blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "Hello World";
    }
}
