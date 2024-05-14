package com.example.promonade.repositories;

import com.example.promonade.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT COUNT(p) FROM Purchase p WHERE p.purchaseTime BETWEEN :startDate AND :endDate")
    long countPurchasesInPeriod(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT SUM(p.pricePaid) FROM Purchase p WHERE p.purchaseTime BETWEEN :startDate AND :endDate")
    double sumRevenueInPeriod(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT SUM(p.pricePaid) FROM Purchase p WHERE p.purchaseTime BETWEEN :startDate AND :endDate AND p.promotionCoupon = :couponCode")
    double sumRevenueInPeriodWithCoupon(LocalDateTime startDate, LocalDateTime endDate, String couponCode);

    @Query("SELECT p.promotionCoupon FROM Purchase p WHERE p.purchaseTime BETWEEN :startDate AND :endDate GROUP BY p.promotionCoupon ORDER BY COUNT(p.promotionCoupon) DESC")
    List<String> findTop5CouponsInPeriod(LocalDateTime startDate, LocalDateTime endDate);
}
