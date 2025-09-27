package com.DoubleBerserker.Personal.Blog.services;

import com.DoubleBerserker.Personal.Blog.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
}
