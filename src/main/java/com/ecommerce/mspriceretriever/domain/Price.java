package com.ecommerce.mspriceretriever.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Price {

    int brandId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int rate;
    String productId;
    double price;
    String currency;
}
