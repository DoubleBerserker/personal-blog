package io.github.DoubleBerserker.stele.controller;

import io.github.DoubleBerserker.stele.dto.PostDto;
import io.github.DoubleBerserker.stele.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping({"/", "/home"})
    public String getHomepage(Model model) {
        List<PostDto> latestPosts = postService.getLatestPosts(2);

        model.addAttribute("latestPosts", latestPosts);

        // Page Structure
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
