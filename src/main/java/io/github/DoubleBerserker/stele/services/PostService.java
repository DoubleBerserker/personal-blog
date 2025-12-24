package io.github.DoubleBerserker.stele.services;

import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;

import java.util.List;

public interface PostService {

    List<PostSummaryDto> getLatestPosts(Integer numberOfPosts);

    PostResponseDto getPostById(String id);

}
