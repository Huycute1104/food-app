package com.example.food.serviceImplement;

import com.example.food.dto.Request.OrderRequest.CreateOrderRequest;
import com.example.food.dto.Response.OrderResponse.OrderResponse;
import com.example.food.model.Cart;
import com.example.food.model.Order;
import com.example.food.repository.CartRepo;
import com.example.food.repository.OrderRepo;
import com.example.food.repository.UserRepo;
import com.example.food.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CartRepo cartRepo;

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getOrderOfUser(int customerId) {
        var user = userRepo.findUserByUsersID(customerId).orElse(null);
        if (user != null) {
            return orderRepo.findOrderByCustomer(user);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        int userId = request.getUser();
        double total = request.getTotal();
        LocalDateTime dateTime = LocalDateTime.now();
        var user = userRepo.findUserByUsersID(userId).orElse(null);
        if (user != null) {
            double balance = user.getAccountBalance();
            if (balance >= total) {
                user.setAccountBalance(user.getAccountBalance() - total);
                List<Cart> cartItems = cartRepo.findByUser(user);
                if (!cartItems.isEmpty()) {
                    Order order = Order.builder()
                            .orderDate(dateTime)
                            .total(total)
                            .customer(user)
                            .build();
                    orderRepo.save(order);
                    userRepo.save(user);
                    return OrderResponse.builder()
                            .status("Create order successful")
                            .order(order)
                            .build();
                } else {
                    return OrderResponse.builder()
                            .status("Create fail")
                            .order(null)
                            .build();
                }
            } else {
                return OrderResponse.builder()
                        .status("Your balance is not enough")
                        .order(null)
                        .build();
            }
        } else {
            return OrderResponse.builder()
                    .status("User not found")
                    .order(null)
                    .build();
        }
    }
}
