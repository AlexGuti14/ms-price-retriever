package com.ecommerce.mspriceretriever.integration;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static com.ecommerce.mspriceretriever.PriceMock.PriceMock.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    void beforeEach() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void test1GetCurrentPriceByBrandIdAndProductId() throws Exception {
        final PriceDTO expectedResponse = getExpectedPriceDTO(
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1,
                PRICE_TEST_1);
        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID)
                        .param("date", String.valueOf(DATE_TEST_1))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedResponse, mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class));
    }

    @Test
    void test2GetCurrentPriceByBrandIdAndProductId() throws Exception {
        final PriceDTO expectedResponse = getExpectedPriceDTO(
                LocalDateTime.parse("2020-06-14T15:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"),
                2,
                PRICE_TEST_2);

        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID)
                        .param("date", String.valueOf(DATE_TEST_2))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedResponse, mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class));
    }

    @Test
    void test3GetCurrentPriceByBrandIdAndProductId() throws Exception {
        final PriceDTO expectedResponse = getExpectedPriceDTO(
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1,
                PRICE_TEST_1);

        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID)
                        .param("date", String.valueOf(DATE_TEST_3))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedResponse, mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class));
    }

    @Test
    void test4GetCurrentPriceByBrandIdAndProductId() throws Exception {
        final PriceDTO expectedResponse = getExpectedPriceDTO(
                LocalDateTime.parse("2020-06-15T00:00:00"),
                LocalDateTime.parse("2020-06-15T11:00:00"),
                3,
                PRICE_TEST_4);

        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID)
                        .param("date", String.valueOf(DATE_TEST_4))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedResponse, mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class));
    }

    @Test
    void test5GetCurrentPriceByBrandIdAndProductId() throws Exception {
        final PriceDTO expectedResponse = getExpectedPriceDTO(
                LocalDateTime.parse("2020-06-15T16:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                4,
                PRICE_TEST_5);

        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID)
                        .param("date", String.valueOf(DATE_TEST_5))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedResponse, mapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class));
    }


    @Test
    void testGetCurrentPriceByBrandIdAndProductIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1.0/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", PRODUCT_ID_NOT_FOUND)
                        .param("date", String.valueOf(DATE_TEST_1))
                        .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(format("Price not found for brandId (%s), productId (%s), date (%s)",
                        BRAND_ID, PRODUCT_ID_NOT_FOUND, DATE_TEST_1)));
    }
}
