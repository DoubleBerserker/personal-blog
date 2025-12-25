package io.github.DoubleBerserker.stele.controller;

import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.enums.PageNameEnum;
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

        int numberOfLatestPostsToShow = 2;
        String pageHeadTitle = "Home";

        List<PostSummaryDto> latestPosts = postService.getLatestPosts(numberOfLatestPostsToShow);

        model.addAttribute("latestPosts", latestPosts);

        // Page structure attributes
        model.addAttribute("title", pageHeadTitle);
        model.addAttribute("page", PageNameEnum.HOMEPAGE.value);

        return PageNameEnum.BASE.value;
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        String pageHeadTitle = "About";

        // Page structure attributes
        model.addAttribute("title", pageHeadTitle);
        model.addAttribute("page", PageNameEnum.ABOUT.value);

        return PageNameEnum.BASE.value;
    }

}
