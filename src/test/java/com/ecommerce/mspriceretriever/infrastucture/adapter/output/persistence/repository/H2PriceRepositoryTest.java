package com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.repository;

import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.domain.PriceNotFoundException;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.entity.PriceEntity;
import com.ecommerce.mspriceretriever.infrastucture.adapter.output.persistence.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ecommerce.mspriceretriever.mock.PriceMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class H2PriceRepositoryTest {

    @Mock
    private SpringJpaH2PriceRepository jpaH2PriceRepository;
    @Mock
    private PriceMapper priceMapper;
    @InjectMocks
    private H2PriceRepository priceRepository;

    @Test
    void testFindCurrentPriceByBrandIdAndProductId() {
        final PriceEntity priceEntity = getPriceEntity();
        final Price expectedPrice = getPrice();

        doReturn(Optional.of(priceEntity)).when(jpaH2PriceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
        doReturn(expectedPrice).when(priceMapper).toDomain(priceEntity);

        final Price price = priceRepository.findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        assertEquals(expectedPrice, price);
        verify(jpaH2PriceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
        verify(priceMapper).toDomain(priceEntity);
    }

    @Test
    void testFindCurrentPriceByBrandIdAndProductIdNotFound() {
        doReturn(Optional.empty()).when(jpaH2PriceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final PriceNotFoundException error = assertThrows(PriceNotFoundException.class, () ->
                priceRepository.findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1));

        assertThat(error).isNotNull();
        assertThat(error.getMessage()).contains("Price not found");
        verify(jpaH2PriceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }
}