package com.example.food.Repository;

import com.example.food.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food,Integer> {
    Optional<Food> findFoodByFoodID(int id);
    Optional<Food> findFoodByFoodName(String name);
}
