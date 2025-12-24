package io.github.DoubleBerserker.stele.services.impl;

import io.github.DoubleBerserker.stele.entities.Category;
import io.github.DoubleBerserker.stele.repositories.CategoryRepository;
import io.github.DoubleBerserker.stele.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category already exists");
        }
        return categoryRepository.save(category);
    }
}
