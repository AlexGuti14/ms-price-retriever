package com.ecommerce.mspriceretriever.controller;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.ecommerce.mspriceretriever.exception.PriceNotFoundException;
import com.ecommerce.mspriceretriever.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.ecommerce.mspriceretriever.mock.PriceMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testGetCurrentPriceByBrandIdAndProductId() {
        final PriceDTO priceDTO = getPriceDTO();
        doReturn(priceDTO).when(priceService).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final ResponseEntity<PriceDTO> priceResponse = priceController.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        assertThat(priceResponse).isNotNull();
        assertEquals(HttpStatus.OK, priceResponse.getStatusCode());
        assertThat(priceResponse.getBody()).isNotNull();
        assertEquals(ResponseEntity.ok(priceDTO), priceResponse);
        verify(priceService).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }

    @Test
    void testGetCurrentPriceByBrandIdAndProductIdNotFound() {
        doThrow(new PriceNotFoundException("Price not found")).when(priceService)
                .getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1);

        final PriceNotFoundException error = assertThrows(PriceNotFoundException.class, () ->
                priceController.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1));

        assertThat(error).isNotNull();
        assertThat(error.getMessage()).contains("Price not found");
        verify(priceService).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1);
    }
}