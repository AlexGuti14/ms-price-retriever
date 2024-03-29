package com.ecommerce.mspriceretriever.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Price {

    int brandId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int rate;
    String productId;
    double price;
    String currency;
}
