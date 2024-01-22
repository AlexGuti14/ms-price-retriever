package com.ecommerce.mspriceretriever.domain.port.output;

import com.ecommerce.mspriceretriever.domain.Price;

import java.time.LocalDateTime;

public interface PriceRepository {

    Price findCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date);
}
