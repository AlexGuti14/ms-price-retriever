package com.ecommerce.mspriceretriever.infrastucture.adapter.input.rest;

import com.ecommerce.mspriceretriever.application.usecase.GetPriceUseCase;
import com.ecommerce.mspriceretriever.domain.Price;
import com.ecommerce.mspriceretriever.domain.PriceNotFoundException;
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
    private GetPriceUseCase getPriceUseCase;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testGetCurrentPriceByBrandIdAndProductId() {
        final Price price = getPrice();
        doReturn(price).when(getPriceUseCase).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        final ResponseEntity<Price> priceResponse = priceController.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);

        assertThat(priceResponse).isNotNull();
        assertEquals(HttpStatus.OK, priceResponse.getStatusCode());
        assertThat(priceResponse.getBody()).isNotNull();
        assertEquals(ResponseEntity.ok(price), priceResponse);
        verify(getPriceUseCase).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID, DATE_TEST_1);
    }

    @Test
    void testGetCurrentPriceByBrandIdAndProductIdNotFound() {
        doThrow(new PriceNotFoundException("Price not found")).when(getPriceUseCase)
                .getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1);

        final PriceNotFoundException error = assertThrows(PriceNotFoundException.class, () ->
                priceController.getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1));

        assertThat(error).isNotNull();
        assertThat(error.getMessage()).contains("Price not found");
        verify(getPriceUseCase).getCurrentPriceByBrandIdAndProductId(BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1);
    }
}