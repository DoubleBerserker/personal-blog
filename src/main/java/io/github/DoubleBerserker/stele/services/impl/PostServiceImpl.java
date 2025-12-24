package io.github.DoubleBerserker.stele.services.impl;

import io.github.DoubleBerserker.stele.dto.PostDto;
import io.github.DoubleBerserker.stele.repositories.PostRepository;
import io.github.DoubleBerserker.stele.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDto> getLatestPosts(Integer numberOfPosts) {

        List<PostDto> latestPosts = List.of();
        if (numberOfPosts == 0) {
            return latestPosts;
            // TODO If numberOfPosts == 0, return all the posts?? Or maybe a certain preset MAX
        }

        Pageable pageable = PageRequest.of(0, numberOfPosts);
        latestPosts = postRepository.findLatestPostsByNumberOfPosts(pageable);

        return latestPosts;
    }

}
