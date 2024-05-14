package com.example.promonade.service;

import com.example.promonade.dto.response.analysticsdtos.ConversionRateResponse;
import com.example.promonade.dto.response.analysticsdtos.RevenueResponse;
import com.example.promonade.dto.response.analysticsdtos.TrendingCouponsResponse;
import com.example.promonade.repositories.CustomerRepository;
import com.example.promonade.repositories.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnalyticsService {

    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;

    public AnalyticsService(CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public double getConversionRate(LocalDateTime startDate, LocalDateTime endDate) {
        long totalLogins = customerRepository.countLoginsInPeriod(startDate, endDate);
        long totalPurchases = purchaseRepository.countPurchasesInPeriod(startDate, endDate);
        return totalLogins == 0 ? 0 : (double) totalPurchases / totalLogins;
    }

    public double getRevenueGenerated(LocalDateTime startDate, LocalDateTime endDate) {
        return purchaseRepository.sumRevenueInPeriod(startDate, endDate);
    }

    public double getRevenueGeneratedWithCoupon(LocalDateTime startDate, LocalDateTime endDate, String couponCode) {
        return purchaseRepository.sumRevenueInPeriodWithCoupon(startDate, endDate, couponCode);
    }

    public List<String> getTrendingCoupons(LocalDateTime startDate, LocalDateTime endDate) {
        return purchaseRepository.findTop5CouponsInPeriod(startDate, endDate);
    }
}