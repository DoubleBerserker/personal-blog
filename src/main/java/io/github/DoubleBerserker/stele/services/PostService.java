package io.github.DoubleBerserker.stele.services;

import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    PostResponseDto getPostById(String id);

    List<PostSummaryDto> getLatestPostsSummarized(Integer numberOfPosts);

    Page<PostResponseDto> getLatestPostsByOffset(Pageable pageable);

}
