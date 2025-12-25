package io.github.DoubleBerserker.stele.dto;

import io.github.DoubleBerserker.stele.entities.Category;
import io.github.DoubleBerserker.stele.entities.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostResponseDto(
        UUID id,
        String title,
        String content,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Category category
) {}