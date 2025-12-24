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
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String getPostsMainPage(Model model) {
        List<PostDto> latestPosts = postService.getLatestPosts(0);

        // Page Structure
        model.addAttribute("activePage", "post");
        model.addAttribute("title", "Post");
        model.addAttribute("page", "post");
        return "base";
    }

    @GetMapping()
    public PostDto getPosts() {
        PostDto postDto = new PostDto();
        return postDto;
    }
}
