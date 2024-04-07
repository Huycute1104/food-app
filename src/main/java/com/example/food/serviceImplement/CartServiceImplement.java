package com.example.food.serviceImplement;

import com.example.food.dto.Request.CartRequest.AddToCartRequest;
import com.example.food.dto.Response.CartResponse.CartResponse;
import com.example.food.model.Cart;
import com.example.food.repository.CartRepo;
import com.example.food.repository.FoodRepo;
import com.example.food.repository.UserRepo;
import com.example.food.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplement implements CartService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FoodRepo foodRepo;
    @Autowired
    private CartRepo cartRepo;

    @Override
    public CartResponse addToCart(AddToCartRequest request) {
        int customerId = request.getCustomerID();
        int foodId = request.getFoodID();
        var customer = userRepo.findUserByUsersID(customerId).orElse(null);
        if (customer != null) {
            var food = foodRepo.findFoodByFoodID(foodId).orElse(null);
            if (food != null) {
                var checkCart = cartRepo.findCartByUserAndFood(customer, food).orElse(null);
                if (checkCart != null) {
                    if (checkCart.getQuantity() < food.getQuantity()) {
                        checkCart.setQuantity(checkCart.getQuantity() + 1);
                        cartRepo.save(checkCart);
                        return CartResponse.builder()
                                .status("Add to cart successfully")
                                .cart(checkCart)
                                .build();
                    } else {
                        return CartResponse.builder()
                                .status("Quantity not enough")
                                .cart(checkCart)
                                .build();
                    }
                } else {
                    Cart cart = Cart.builder()
                            .user(customer)
                            .food(food)
                            .quantity(1)
                            .build();
                    cartRepo.save(cart);
                    return CartResponse.builder()
                            .status("Add to cart successfully")
                            .cart(cart)
                            .build();
                }
            } else {
                return CartResponse.builder()
                        .status("Food not found")
                        .cart(null)
                        .build();
            }
        } else {
            return CartResponse.builder()
                    .status("Customer not found")
                    .cart(null)
                    .build();
        }
    }
}
