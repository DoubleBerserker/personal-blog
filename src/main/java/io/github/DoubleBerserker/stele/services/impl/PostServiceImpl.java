package io.github.DoubleBerserker.stele.services.impl;

import io.github.DoubleBerserker.stele.dto.CategoryDto;
import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.entities.Post;
import io.github.DoubleBerserker.stele.repositories.PostRepository;
import io.github.DoubleBerserker.stele.services.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto getPostById(String id) {

        Optional<Post> post = postRepository.findById(UUID.fromString(id));

        if (post.isEmpty()) {
            return null;
        }

        return post.map(this::mapPostEntityToResponse)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    @Override
    public List<PostSummaryDto> getLatestPosts(Integer numberOfPosts) {

        List<PostSummaryDto> latestPosts = List.of();
        if (numberOfPosts == 0) {
            return latestPosts;
            // TODO If numberOfPosts == 0, return all the posts?? Or maybe a certain preset MAX
        }

        Pageable pageable = PageRequest.of(0, numberOfPosts);
        latestPosts = postRepository.findLatestPostsByNumberOfPosts(pageable);

        return latestPosts;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponseDto> getLatestPostsByOffset(Pageable pageable) {

        // Gets a Page<Post> object from repository which is mapped to Page<PostResponseDto>. Convert to exploded form if it gets confusing
        return postRepository.findAll(pageable).map(this::mapPostEntityToResponse);
    }

    private PostResponseDto mapPostEntityToResponse(Post post) {
        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                CategoryDto.builder()
                        .id(post.getCategory().getId())
                        .name(post.getCategory().getName())
                        .postCount(0) // Avoid accessing lazy-loaded posts collection here to prevent N+1 queries
                        .build()
        );
    }

}
