package io.github.DoubleBerserker.stele.controller;

import io.github.DoubleBerserker.stele.dto.CategoryDto;
import io.github.DoubleBerserker.stele.dto.CreateCategoryRequestDto;
import io.github.DoubleBerserker.stele.entities.Category;
import io.github.DoubleBerserker.stele.mappers.CategoryMapper;
import io.github.DoubleBerserker.stele.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories().stream()
                .map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequestDto);
        Category createdCategory = categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(categoryMapper.toDto(createdCategory),
                HttpStatus.CREATED);
    }
}
