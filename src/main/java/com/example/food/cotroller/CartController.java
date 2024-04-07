package com.example.food.cotroller;

import com.example.food.dto.Request.CartRequest.AddToCartRequest;
import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CartResponse.CartResponse;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("")
    //    @PreAuthorize("hasAuthority('customer:create')")
    public ResponseEntity<CartResponse> createCategory(@RequestBody AddToCartRequest request) {
        return ResponseEntity.ok(cartService.addToCart(request));
    }
}
