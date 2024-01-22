package com.ecommerce.mspriceretriever.application.usecase;

import com.ecommerce.mspriceretriever.domain.Price;

import java.time.LocalDateTime;

public interface GetPriceUseCase {


    Price getCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date);
}
