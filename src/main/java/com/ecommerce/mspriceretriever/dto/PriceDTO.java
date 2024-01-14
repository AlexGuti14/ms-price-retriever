package com.ecommerce.mspriceretriever.dto;

import com.ecommerce.mspriceretriever.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int rate;
    private String productId;
    private double price;
    private String currency;

    public PriceDTO(final Price price) {
        this.brandId = price.getBrandId();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.rate = price.getRate();
        this.productId = price.getProductId();
        this.price = price.getPrice();
        this.currency = price.getCurrency();
    }
}
