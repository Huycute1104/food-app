package com.example.food.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Orderdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderdetailID")
    private int orderDetailID;

    @ManyToOne
    @JoinColumn(name = "FoodID")
    private Food food;

    @Column(name = "Price")
    private double price;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Order order;
}
