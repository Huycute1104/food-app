package com.example.food.cotroller;

import com.example.food.dto.Request.CartRequest.AddToCartRequest;
import com.example.food.dto.Request.CartRequest.UpdateCartRequest;
import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CartResponse.CartResponse;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.model.Cart;
import com.example.food.model.Food;
import com.example.food.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('customer:update')")
    public ResponseEntity<CartResponse> updateUser(
            @PathVariable int id,
            @RequestBody UpdateCartRequest request) {
        return ResponseEntity.ok(cartService.updateCart(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartResponse> deleteFood(@PathVariable int id) {
        CartResponse response = cartService.deleteCartItem(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<Cart> getCartByUser(@PathVariable int id) {
        return cartService.getCartByUser(id);
    }

}
