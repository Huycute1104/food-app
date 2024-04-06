package com.example.food.serviceImplement;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.food.dto.Request.FoodRequest.CreateFoodRequest;
import com.example.food.dto.Response.FoodResponse.FoodResponse;
import com.example.food.model.Food;
import com.example.food.repository.CategoryRepo;
import com.example.food.repository.FoodRepo;
import com.example.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FoodServiceImplement implements FoodService {
    @Autowired
    private FoodRepo foodRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public FoodResponse createFood(CreateFoodRequest request, MultipartFile file) {
        int category = request.getCategory();
        //check category exits or not
        var cate = categoryRepo.findCategoriesByCategoryId(category).orElse(null);
        if (cate == null) {
            return FoodResponse.builder()
                    .status("Category not found")
                    .food(null)
                    .build();
        } else {
            String name = request.getFoodName();
            String description = request.getDescription();
            double price = request.getPrice();
            LocalDateTime postedAt = LocalDateTime.now();
            String foodImage = uploadImageToCloudinary(file);
            // check food exist or not by name
            var food = foodRepo.findFoodByFoodName(name).orElse(null);
            if (food == null) {
                Food food1 = Food.builder()
                        .foodName(name)
                        .foodImage(foodImage)
                        .price(price)
                        .category(cate)
                        .description(description)
                        .dateAt(postedAt)
                        .build();
                foodRepo.save(food1);
                return FoodResponse.builder()
                        .status("Create Food Successfully")
                        .food(food1)
                        .build();
            }else {
                return FoodResponse.builder()
                        .status("Food already exists")
                        .food(null)
                        .build();
            }
        }

    }

    public String uploadImageToCloudinary(MultipartFile file) {
        try {
            // Upload image to Cloudinary
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

            // Get the URL of the uploaded image from Cloudinary response
            return (String) uploadResult.get("url");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
