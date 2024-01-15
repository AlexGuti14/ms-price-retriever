package com.ecommerce.mspriceretriever.service;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.ecommerce.mspriceretriever.exception.PriceNotFoundException;
import com.ecommerce.mspriceretriever.repository.PriceRepository;
import com.ecommerce.mspriceretriever.service.impl.PriceServiceImpl;
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
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;
    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testGetCurrentPriceByBrandIdAndProductId() {
        final PriceDTO expectedPriceDTO = getPriceDTO();
        doReturn(Optional.of(getPrice())).when(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final PriceDTO priceDTO = priceService.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        assertEquals(priceDTO, expectedPriceDTO);
        verify(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }

    @Test
    void testGetCurrentPriceByBrandIdAndProductIdNotFound() {
        doReturn(Optional.empty()).when(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final PriceNotFoundException error = assertThrows(PriceNotFoundException.class, () ->
                priceService.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1));

        assertThat(error).isNotNull();
        assertThat(error.getMessage()).contains("Price not found");
        verify(priceRepository).findCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }
}
