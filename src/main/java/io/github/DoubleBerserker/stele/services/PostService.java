package io.github.DoubleBerserker.stele.services;

import io.github.DoubleBerserker.stele.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getLatestPosts(Integer numberOfPosts);

}
