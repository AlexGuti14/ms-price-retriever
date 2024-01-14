package com.ecommerce.mspriceretriever.controller;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.ecommerce.mspriceretriever.service.PriceService;
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

    private final PriceService priceService;

    @GetMapping
    ResponseEntity<PriceDTO> getCurrentPriceByBrandIdAndProductId(
            @RequestParam("brandId") final int brandId,
            @RequestParam("productId") final String productId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") final LocalDateTime date) {

        return ResponseEntity.ok(priceService.getCurrentPriceByBrandIdAndProductId(brandId, productId, date));
    }
}
