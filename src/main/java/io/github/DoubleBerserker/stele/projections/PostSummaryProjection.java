package io.github.DoubleBerserker.stele.projections;

import java.util.UUID;

public interface PostSummaryProjection {

    UUID getId();
    String getTitle();
    String getContent();

}
