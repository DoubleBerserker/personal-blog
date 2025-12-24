package io.github.DoubleBerserker.stele.dto;

import io.github.DoubleBerserker.stele.entities.Category;
import io.github.DoubleBerserker.stele.entities.Status;
import io.github.DoubleBerserker.stele.entities.Tag;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record PostResponseDto(
        UUID id,
        String title,
        String content,
        Status status,
        LocalDateTime createdAt, // Formatted as String for easier display in HTML
        LocalDateTime updatedAt, // Formatted as String for easier display in HTML
        Category category,
        Set<String> tags
) {}