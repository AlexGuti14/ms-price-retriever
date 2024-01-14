package com.ecommerce.mspriceretriever.service;

import com.ecommerce.mspriceretriever.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDTO getCurrentPriceByBrandIdAndProductId(int brandId, String productId, LocalDateTime date);
}
