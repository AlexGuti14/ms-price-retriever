package com.ecommerce.mspriceretriever.application.service;

import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.domain.port.output.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ecommerce.mspriceretriever.mock.PriceMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetPriceServiceTest {

    @Mock
    private PriceRepository priceRepository;
    @InjectMocks
    private GetPriceService priceService;

    @Test
    void testGetCurrentPriceByBrandIdAndProductId() {
        final Price expectedPrice = getPrice();
        doReturn(getPrice()).when(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final Price price = priceService.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        assertEquals(price, expectedPrice);
        verify(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }
}
