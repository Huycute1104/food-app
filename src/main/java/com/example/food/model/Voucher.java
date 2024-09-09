package com.example.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Voucher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VoucherID")
    private int voucherID;

    @Column(name = "VoucherName", length = 500)
    private String voucherName;

    @Column(name = "StartTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "EndTime", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "Value", nullable = false)
    private int value;

    @Column(name = "Description", length = 500)
    private String description;

    @OneToMany(mappedBy = "voucher", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<Order> orders;

}
