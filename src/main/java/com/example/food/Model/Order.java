package com.example.food.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderID;

    @Column(name = "OrderDate", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "Total")
    private double total;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private User customer;

    private int orderCode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    @ManyToOne(cascade = CascadeType.MERGE, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "VoucherID", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Voucher voucher;
}
