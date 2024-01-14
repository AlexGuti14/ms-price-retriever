package com.ecommerce.mspriceretriever.exception;

import static java.lang.String.format;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(final String reason, final Object... args) {
        super(format(reason, args));
    }
}
