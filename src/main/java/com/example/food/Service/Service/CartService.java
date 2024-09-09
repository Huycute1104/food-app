package com.example.food.Service.Service;

import com.example.food.ViewModel.Request.CartRequest.AddToCartRequest;
import com.example.food.ViewModel.Request.CartRequest.UpdateCartRequest;
import com.example.food.ViewModel.Response.CartResponse.CartResponse;
import com.example.food.Model.Cart;
import com.example.food.Repository.CartRepo;
import com.example.food.Repository.FoodRepo;
import com.example.food.Repository.UserRepo;
import com.example.food.Service.IService.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {
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

    @Override
    public CartResponse updateCart(int cartId,UpdateCartRequest request) {
        int quantity = request.getQuantity();
        if(quantity<0){
            return CartResponse.builder()
                    .status("Value invalid")
                    .cart(null)
                    .build();
        }
        var cart = cartRepo.findCartByCartID(cartId).orElse(null);
        if(cart != null){
            if(cart.getFood().getQuantity()>=quantity){
                cart.setQuantity(quantity);
                cartRepo.save(cart);
                return CartResponse.builder()
                        .status("Update cart successfully")
                        .cart(cart)
                        .build();
            }else {
                return CartResponse.builder()
                        .status("Quantity has been exceeded")
                        .cart(null)
                        .build();
            }
        }else {
            return CartResponse.builder()
                    .status("Can not found cart item")
                    .cart(null)
                    .build();
        }
    }

    @Override
    public CartResponse deleteCartItem(int cartId) {
        var cart = cartRepo.findCartByCartID(cartId).orElse(null);
        if (cart == null) {
            return CartResponse.builder()
                    .status("Food not found")
                    .cart(null)
                    .build();
        }else{
            cartRepo.delete(cart);
            return CartResponse.builder()
                    .status("Food deleted successfully")
                    .cart(null)
                    .build();
        }
    }

    @Override
    public List<Cart> getCartByUser(int userId) {
        var user = userRepo.findUserByUsersID(userId).orElse(null);
        if(user != null){
            return cartRepo.findByUser(user);
        }
        else {
            return new ArrayList<>();
        }
    }
}
