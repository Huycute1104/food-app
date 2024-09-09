package com.example.food.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private int cartID;

    @ManyToOne
    @JoinColumn(name = "UsersID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "FoodID")
    private Food food;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

}
