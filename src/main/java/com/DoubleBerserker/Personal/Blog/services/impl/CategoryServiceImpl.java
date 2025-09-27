package com.DoubleBerserker.Personal.Blog.services.impl;

import com.DoubleBerserker.Personal.Blog.entities.Category;
import com.DoubleBerserker.Personal.Blog.repositories.CategoryRepository;
import com.DoubleBerserker.Personal.Blog.services.CategoryService;
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
}
