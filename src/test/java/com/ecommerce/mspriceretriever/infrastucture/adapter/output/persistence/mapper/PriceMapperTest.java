package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.mapper;

import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ecommerce.mspriceretriever.mock.PriceMock.getPrice;
import static com.ecommerce.mspriceretriever.mock.PriceMock.getPriceEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperTest {
    private PriceMapper priceMapper;

    @BeforeEach
    void setUp() {
        this.priceMapper = new PriceMapper();
    }

    @Test
    void toDomain() {
        final PriceEntity priceEntity = getPriceEntity();
        final Price expectedPrice = getPrice();

        final Price price = priceMapper.toDomain(priceEntity);

        assertEquals(expectedPrice, price);
    }
}