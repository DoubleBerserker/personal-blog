package io.github.DoubleBerserker.stele.controller;

import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.enums.PageNameEnum;
import io.github.DoubleBerserker.stele.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String getPostsMainPage(Model model) {

        String pageHeadTitle = "Post";

        List<PostSummaryDto> latestPosts = postService.getLatestPosts(0);

        // Page structure attributes
        model.addAttribute("title", pageHeadTitle);
        model.addAttribute("page", PageNameEnum.POSTS_MAIN_PAGE.value);

        return PageNameEnum.BASE.value;
    }

    @GetMapping("/posts/{id}")
    public String getPostPage(Model model, @PathVariable String id) {

        PostResponseDto post = postService.getPostById(id);

        model.addAttribute("post", post);

        // Page structure attributes
        model.addAttribute("title", post.title());
        model.addAttribute("page", PageNameEnum.POST.value);

        return PageNameEnum.BASE.value;
    }

}
