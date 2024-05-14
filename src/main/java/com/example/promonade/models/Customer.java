package com.example.promonade.models;

import com.example.promonade.enums.customerEnums.AgeCategory;
import com.example.promonade.enums.customerEnums.Gender;
import com.example.promonade.enums.customerEnums.MaritalStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private int age;

    @Enumerated(EnumType.STRING)
    private AgeCategory ageCategory;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime accountCreated;

    private int loginCount;

    private LocalDateTime lastLogin;

    private int purchaseCount;
}
