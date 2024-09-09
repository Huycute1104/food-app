package com.example.food.Service.Service;

import com.example.food.ViewModel.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.food.ViewModel.Response.OrderDetailResponse.OrderDetailResponse;
import com.example.food.Model.Cart;
import com.example.food.Model.Food;
import com.example.food.Model.OrderDetail;
import com.example.food.Model.User;
import com.example.food.Repository.*;
import com.example.food.Service.IService.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private FoodRepo foodRepo;

    @Override
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest request) {
        int orderId = request.getOrderId();
        var order = orderRepo.findOrderByOrderID(orderId).orElse(null);
        if (order != null) {
            int userId = order.getCustomer().getUsersID();
            var user = userRepo.findUserByUsersID(userId).orElse(null);
            if (user != null) {
                List<Cart> cartItems = cartRepo.findByUser(user);
                if (!cartItems.isEmpty()) {
                    for (Cart cartItem : cartItems) {
                        OrderDetail orderDetail = OrderDetail.builder()
                                .order(order)
                                .price(cartItem.getFood().getPrice())
                                .quantity(cartItem.getQuantity())
                                .food(cartItem.getFood())
                                .build();
                        double total = orderDetail.getQuantity() * orderDetail.getPrice();
                        orderDetailRepo.save(orderDetail);
                        Food food = cartItem.getFood();
                        food.setQuantitySold(food.getQuantitySold() + cartItem.getQuantity());
                        foodRepo.save(food);
                        cartRepo.delete(cartItem);
                        User user1 = order.getCustomer();
                        user1.setAccountBalance(user1.getAccountBalance() - total);
                        userRepo.save(user1);
                    }
                    return OrderDetailResponse.builder()
                            .status("Create order detail successful")
                            .build();
                } else {
                    return OrderDetailResponse.builder()
                            .status("Cart is empty")
                            .orderDetail(null)
                            .build();
                }
            } else {
                return OrderDetailResponse.builder()
                        .status("User not found")
                        .build();
            }
        }else {
            return OrderDetailResponse.builder()
                    .orderDetail(null)
                    .status("Order not found")
                    .build();
        }
    }

}
