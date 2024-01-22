package com.ecommerce.mspriceretriever.infrastucture.adapter.input.rest;

import com.ecommerce.mspriceretriever.application.usecase.GetPriceUseCase;
import com.ecommerce.mspriceretriever.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1.0/prices")
@RequiredArgsConstructor
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;

    @GetMapping
    public ResponseEntity<Price> getCurrentPriceByBrandIdAndProductId(
            @RequestParam("brandId") final int brandId,
            @RequestParam("productId") final String productId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") final LocalDateTime date) {

        return ResponseEntity.ok(getPriceUseCase.getCurrentPriceByBrandIdAndProductId(brandId, productId, date));
    }
}
