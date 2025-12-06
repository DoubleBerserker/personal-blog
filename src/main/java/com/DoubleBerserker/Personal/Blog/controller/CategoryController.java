package com.DoubleBerserker.Personal.Blog.controller;

import com.DoubleBerserker.Personal.Blog.dto.CategoryDto;
import com.DoubleBerserker.Personal.Blog.dto.CreateCategoryRequestDto;
import com.DoubleBerserker.Personal.Blog.entities.Category;
import com.DoubleBerserker.Personal.Blog.mappers.CategoryMapper;
import com.DoubleBerserker.Personal.Blog.services.CategoryService;
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
