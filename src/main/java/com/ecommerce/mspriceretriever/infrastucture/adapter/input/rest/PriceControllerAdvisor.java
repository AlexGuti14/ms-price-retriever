package com.ecommerce.mspriceretriever.infrastucture.adapter.input.rest;

import com.ecommerce.mspriceretriever.domain.Error;
import com.ecommerce.mspriceretriever.domain.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PriceControllerAdvisor {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PriceNotFoundException.class)
    public Error priceNotFoundHandler(final PriceNotFoundException ex) {
        return new Error(ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Error genericExceptionHandler(final Exception ex) {
        return new Error(ex.getMessage());
    }
}