package com.example.food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "ListPrice", nullable = false)
    private double listPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DateAdded")
    private Date dateAdded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private Category category;


}
