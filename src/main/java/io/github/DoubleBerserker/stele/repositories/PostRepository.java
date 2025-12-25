package io.github.DoubleBerserker.stele.repositories;

import io.github.DoubleBerserker.stele.dto.PostSummaryDto;
import io.github.DoubleBerserker.stele.entities.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query("SELECT new io.github.DoubleBerserker.stele.dto.PostSummaryDto(p.id, p.title, SUBSTRING(p.content, 1, 200)) " +
            "FROM Post p ORDER BY p.createdAt DESC ")
    List<PostSummaryDto> findLatestPostsByNumberOfPosts(Pageable pageable);

}
