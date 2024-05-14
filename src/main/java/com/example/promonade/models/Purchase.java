package com.example.promonade.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = true)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    private double pricePaid;

    private String promotionCoupon;

    private LocalDateTime purchaseTime;
}
