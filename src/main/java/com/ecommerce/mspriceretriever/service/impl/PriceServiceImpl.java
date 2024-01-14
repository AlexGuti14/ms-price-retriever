package com.ecommerce.mspriceretriever.service.impl;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.ecommerce.mspriceretriever.entity.Price;
import com.ecommerce.mspriceretriever.exception.PriceNotFoundException;
import com.ecommerce.mspriceretriever.repository.PriceRepository;
import com.ecommerce.mspriceretriever.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public PriceDTO getCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date) {
        final Price price = priceRepository.findCurrentPriceByBrandIdAndProductId(brandId, productId, date)
                .orElseThrow(() -> (new PriceNotFoundException(
                        "Price not found for brandId (%s), productId (%s), date (%s)", brandId, productId, date)));
        return new PriceDTO(price);
    }
}
