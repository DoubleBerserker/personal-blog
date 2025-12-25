package io.github.DoubleBerserker.stele.dto;

import io.github.DoubleBerserker.stele.entities.Status;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PostResponseDto(
        UUID id,
        String title,
        String content,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        CategoryDto category
) {}