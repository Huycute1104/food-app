package com.example.food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Food")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FoodID")
    private int foodID;

    @Column(name = "FoodName", length = 20,unique = true)
    private String foodName;

     @Column(name = "FoodImage", length = Integer.MAX_VALUE)
        private String foodImage;

     @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "QuantitySold")
    private int quantitySold;

    @Column(name = "FoodStatus")
    private boolean foodStatus;

    @Column(name = "DateAt")
    private LocalDateTime dateAt;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;


}
