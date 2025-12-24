package com.DoubleBerserker.Personal.Blog.controller;

import com.DoubleBerserker.Personal.Blog.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPostsMainPage(Model model) {
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
