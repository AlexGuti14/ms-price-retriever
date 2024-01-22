package com.ecommerce.mspriceretriever.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int rate;
    private String productId;
    private double price;
    private String currency;
}
