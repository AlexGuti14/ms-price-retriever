package com.ecommerce.mspriceretriever.PriceMock;

import com.ecommerce.mspriceretriever.dto.PriceDTO;
import com.ecommerce.mspriceretriever.entity.Price;

import java.time.LocalDateTime;

public class PriceMock {

    public static final int BRAND_ID = 1;
    public static final String PRODUCT_ID = "35455";
    public static final String PRODUCT_ID_NOT_FOUND = "15455";
    public static final LocalDateTime DATE_TEST_1 = LocalDateTime.parse("2020-06-14T10:00:00");
    public static final LocalDateTime DATE_TEST_2 = LocalDateTime.parse("2020-06-14T16:00:00");
    public static final LocalDateTime DATE_TEST_3 = LocalDateTime.parse("2020-06-14T21:00:00");
    public static final LocalDateTime DATE_TEST_4 = LocalDateTime.parse("2020-06-15T10:00:00");
    public static final LocalDateTime DATE_TEST_5 = LocalDateTime.parse("2020-06-16T21:00:00");
    public static final double PRICE_TEST_1 = 35.50;
    public static final double PRICE_TEST_2 = 25.45;
    public static final double PRICE_TEST_4 = 30.50;
    public static final double PRICE_TEST_5 = 38.95;
    public static final String CURRENCY = "EUR";

    public static Price getPrice() {
        return new Price(1L,
                BRAND_ID,
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1,
                PRODUCT_ID,
                1,
                PRICE_TEST_1,
                CURRENCY);
    }

    public static PriceDTO getPriceDTO() {
        return new PriceDTO(getPrice());
    }

    public static PriceDTO getExpectedPriceDTO(final LocalDateTime startDate, final LocalDateTime endDate,
                                               final int rate, final double price) {
        return new PriceDTO(BRAND_ID, startDate, endDate, rate, PRODUCT_ID, price, CURRENCY);
    }
}
