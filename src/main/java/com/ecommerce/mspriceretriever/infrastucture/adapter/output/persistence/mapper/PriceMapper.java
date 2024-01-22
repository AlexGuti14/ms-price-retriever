package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.mapper;

import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public Price toDomain(final PriceEntity priceEntity) {
        return new Price(priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getRate(),
                priceEntity.getProductId(),
                priceEntity.getPrice(),
                priceEntity.getCurrency());
    }
}
