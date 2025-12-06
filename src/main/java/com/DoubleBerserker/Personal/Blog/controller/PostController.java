package com.DoubleBerserker.Personal.Blog.controller;

import com.DoubleBerserker.Personal.Blog.dto.PostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/posts")
public class PostController {

    @GetMapping()
    public PostDto getPosts() {
        PostDto postDto = new PostDto();
        return postDto;
    }
}
