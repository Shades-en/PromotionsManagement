package com.example.promonade.repositories;

import com.example.promonade.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT SUM(c.loginCount) FROM Customer c WHERE c.lastLoginTime BETWEEN :startDate AND :endDate")
    long countLoginsInPeriod(LocalDateTime startDate, LocalDateTime endDate);
}
