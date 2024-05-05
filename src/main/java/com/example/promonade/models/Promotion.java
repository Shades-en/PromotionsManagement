package com.example.promonade.models;

import com.example.promonade.enums.promotionEnums.PromotionCategory;
import com.example.promonade.enums.promotionEnums.PromotionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    PromotionCategory category;

    String name;

    @Enumerated(EnumType.STRING)
    PromotionType promotionType;

    Date validFrom;

    Date validTill;

    boolean approved;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn()
    User createdBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    Criteria criteria;
}
