package com.example.food.Cotroller;

import com.example.food.ViewModel.Request.CartRequest.AddToCartRequest;
import com.example.food.ViewModel.Request.CartRequest.UpdateCartRequest;
import com.example.food.ViewModel.Response.CartResponse.CartResponse;
import com.example.food.Model.Cart;
import com.example.food.Service.IService.ICartService;
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
    private ICartService ICartService;

    @PostMapping("")
    //    @PreAuthorize("hasAuthority('customer:create')")
    public ResponseEntity<CartResponse> createCategory(@RequestBody AddToCartRequest request) {
        return ResponseEntity.ok(ICartService.addToCart(request));
    }
    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('customer:update')")
    public ResponseEntity<CartResponse> updateUser(
            @PathVariable int id,
            @RequestBody UpdateCartRequest request) {
        return ResponseEntity.ok(ICartService.updateCart(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartResponse> deleteFood(@PathVariable int id) {
        CartResponse response = ICartService.deleteCartItem(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<Cart> getCartByUser(@PathVariable int id) {
        return ICartService.getCartByUser(id);
    }

}
