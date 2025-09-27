package com.DoubleBerserker.Personal.Blog.repositories;

import com.DoubleBerserker.Personal.Blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
