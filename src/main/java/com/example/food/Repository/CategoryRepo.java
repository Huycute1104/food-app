package com.example.food.Repository;

import com.example.food.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoriesByCategoryName(String name);
    Optional<Category> findCategoriesByCategoryId(int id);
}
