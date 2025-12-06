package com.DoubleBerserker.Personal.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("activePage", "home");
        model.addAttribute("title", "Harsh's Blog");
//        model.addAttribute("posts")
        return "homepage";
    }

}
