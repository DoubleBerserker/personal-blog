package io.github.DoubleBerserker.stele.repositories;

import io.github.DoubleBerserker.stele.entities.Post;
import io.github.DoubleBerserker.stele.projections.PostSummaryProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<PostSummaryProjection> findAllBy(Pageable pageable);

}
