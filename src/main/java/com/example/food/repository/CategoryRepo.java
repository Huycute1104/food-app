package com.example.food.repository;

import com.example.food.model.Category;
import com.example.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoriesByCategoryName(String name);
    Optional<Category> findCategoriesByCategoryId(int id);
}
