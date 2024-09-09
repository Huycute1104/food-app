package com.example.food.Cotroller;

import com.example.food.ViewModel.Request.FoodRequest.CreateFoodRequest;
import com.example.food.ViewModel.Request.FoodRequest.UpdateFoodRequest;
import com.example.food.ViewModel.Response.FoodResponse.FoodResponse;
import com.example.food.Model.Food;
import com.example.food.Service.IService.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {

    @Autowired
    private IFoodService IFoodService;

    @GetMapping("")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<Food> getAllUsers() {
        return IFoodService.getAll();
    }
    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<Food> getUserById(@PathVariable int id) {
        return IFoodService.getFoodByID(id);
    }
    @PostMapping("")
    //    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<FoodResponse> createFood(
            @RequestParam("foodName") String foodName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("category") int category,
            @RequestParam("quantity") int quantity,
            @RequestParam("file") MultipartFile file) {
        CreateFoodRequest food = CreateFoodRequest.builder()
                .foodName(foodName)
                .description(description)
                .price(price)
                .category(category)
                .quantity(quantity)
                .build();
        FoodResponse response = IFoodService.createFood(food,file);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<FoodResponse> updateFood(
            @PathVariable int id,
            @RequestParam("foodName") String foodName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("category") int category,
            @RequestParam("quantity") int quantity,
            @RequestParam("file") MultipartFile file) {
        UpdateFoodRequest food = UpdateFoodRequest.builder()
                .foodName(foodName)
                .description(description)
                .price(price)
                .category(category)
                .quantity(quantity)
                .build();
        FoodResponse response = IFoodService.updateFood(id,food,file);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodResponse> deleteFood(@PathVariable int id) {
        FoodResponse response = IFoodService.deleteFood(id);
        return ResponseEntity.ok(response);
    }
}
