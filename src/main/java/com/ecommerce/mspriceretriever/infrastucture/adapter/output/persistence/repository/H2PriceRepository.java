package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.repository;

import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.domain.PriceNotFoundException;
import com.ecommerce.mspriceretriever.domain.port.output.PriceRepository;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity.PriceEntity;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class H2PriceRepository implements PriceRepository {

    private final SpringJpaH2PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Override
    public Price findCurrentPriceByBrandIdAndProductId(final int brandId, final String productId, final LocalDateTime date) {
        final PriceEntity priceEntity = priceRepository.findCurrentPriceByBrandIdAndProductId(brandId, productId, date)
                .orElseThrow(() -> (new PriceNotFoundException(
                        "Price not found for brandId (%s), productId (%s), date (%s)", brandId, productId, date)));
        return priceMapper.toDomain(priceEntity);
    }
}
