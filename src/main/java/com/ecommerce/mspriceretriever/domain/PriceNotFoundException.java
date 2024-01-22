package com.ecommerce.mspriceretriever.domain;

import static java.lang.String.format;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(final String reason, final Object... args) {
        super(format(reason, args));
    }
}
