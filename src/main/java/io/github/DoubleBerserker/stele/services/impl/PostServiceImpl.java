package io.github.DoubleBerserker.stele.services.impl;

import io.github.DoubleBerserker.stele.dto.PostResponseDto;
import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.entities.Post;
import io.github.DoubleBerserker.stele.entities.Tag;
import io.github.DoubleBerserker.stele.repositories.PostRepository;
import io.github.DoubleBerserker.stele.services.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

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
    public PostResponseDto getPostById(String id) {

        Optional<Post> post = postRepository.findById(UUID.fromString(id));

        if (post.isEmpty()) {
            return null;
        }

        return post.map(this::convertPostEntityToResponse)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    private PostResponseDto convertPostEntityToResponse(Post post) {
        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getCategory(),
                post.getTags().stream().map(Tag::getName).collect(Collectors.toSet())
        );
    }

}
