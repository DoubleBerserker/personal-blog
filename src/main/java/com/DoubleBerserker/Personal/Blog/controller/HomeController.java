package com.DoubleBerserker.Personal.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String getHomepage(Model model) {
        model.addAttribute("activePage", "home");
        model.addAttribute("title", "Home");
        model.addAttribute("page", "homepage");
        return "base";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("activePage", "about");
        model.addAttribute("title", "About");
        model.addAttribute("page", "about");
        return "base";
    }

}
