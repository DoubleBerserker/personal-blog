package io.github.DoubleBerserker.stele.services;

import io.github.DoubleBerserker.stele.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
