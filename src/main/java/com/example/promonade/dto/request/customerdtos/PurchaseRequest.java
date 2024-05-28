package com.example.promonade.dto.request.customerdtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PurchaseRequest {

    Long customerId;

    List<Integer> productIdList;

    List<Integer> serviceIdList;

    double amountSpent;

    int promotionId;

}