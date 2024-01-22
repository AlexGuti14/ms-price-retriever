package com.ecommerce.mspriceretriever.application.service;

import com.ecommerce.mspriceretriever.application.usecase.GetPriceUseCase;
import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.domain.port.output.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetPriceService implements GetPriceUseCase {

    private final PriceRepository priceRepository;

    public Price getCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date) {
        return priceRepository.findCurrentPriceByBrandIdAndProductId(brandId, productId, date);
    }
}
