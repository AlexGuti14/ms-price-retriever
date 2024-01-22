package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Entity(name = "PRICES")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int brandId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int rate;
    String productId;
    int priority;
    double price;
    String currency;
}